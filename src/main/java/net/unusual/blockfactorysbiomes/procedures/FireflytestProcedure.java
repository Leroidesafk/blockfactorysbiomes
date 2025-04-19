package net.unusual.blockfactorysbiomes.procedures;

import org.joml.Matrix4f;

import net.unusual.blockfactorysbiomes.entity.FireflyEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.systems.RenderSystem;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FireflytestProcedure {
	private static boolean texture = false;
	private static BufferBuilder bufferBuilder = null;
	private static VertexBuffer vertexBuffer = null;
	private static PoseStack poseStack = null;
	private static Matrix4f projectionMatrix = null;
	private static boolean worldCoordinate = true;
	private static Vec3 offset = Vec3.ZERO;
	private static float partialTick = 0.0F;
	private static int ticks = 0;
	private static int currentStage = 0;
	private static int targetStage = 0; // NONE: 0, SKY: 1, WORLD: 2

	private static void add(double x, double y, double z, float u, float v, int color) {
		if (bufferBuilder == null || !bufferBuilder.building())
			return;
		if (texture) {
			bufferBuilder.vertex(x, y, z).uv(u, v).color(color).endVertex();
		} else {
			bufferBuilder.vertex(x, y, z).color(color).endVertex();
		}
	}

	private static boolean begin(VertexFormat.Mode mode, boolean texture, boolean update) {
		if (bufferBuilder == null || !bufferBuilder.building()) {
			if (update)
				clear();
			if (vertexBuffer == null) {
				FireflytestProcedure.texture = texture;
				bufferBuilder = Tesselator.getInstance().getBuilder();
				if (texture) {
					bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_TEX_COLOR);
				} else {
					bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_COLOR);
				}
				return true;
			}
		}
		return false;
	}

	private static void clear() {
		if (vertexBuffer != null) {
			vertexBuffer.close();
			vertexBuffer = null;
		}
	}

	private static void end() {
		if (bufferBuilder == null || !bufferBuilder.building())
			return;
		if (vertexBuffer != null)
			vertexBuffer.close();
		vertexBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
		vertexBuffer.bind();
		vertexBuffer.upload(bufferBuilder.end());
		VertexBuffer.unbind();
	}

	private static void offset(double x, double y, double z) {
		offset = new Vec3(x, y, z);
	}

	private static void release() {
		targetStage = 0;
	}

	private static VertexBuffer shape() {
		return vertexBuffer;
	}

	private static void system(boolean worldCoordinate) {
		FireflytestProcedure.worldCoordinate = worldCoordinate;
	}

	private static boolean target(int targetStage) {
		if (targetStage == currentStage) {
			FireflytestProcedure.targetStage = targetStage;
			return true;
		}
		return false;
	}

	private static void renderShape(VertexBuffer vertexBuffer, double x, double y, double z, float yaw, float pitch, float roll, float xScale, float yScale, float zScale, int color) {
		if (currentStage == 0 || currentStage != targetStage)
			return;
		if (poseStack == null || projectionMatrix == null)
			return;
		if (vertexBuffer == null)
			return;
		float i, j, k;
		if (!worldCoordinate) {
			i = (float) x;
			j = (float) y;
			k = (float) z;
		} else {
			Vec3 pos = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
			i = (float) (x - pos.x());
			j = (float) (y - pos.y());
			k = (float) (z - pos.z());
		}
		poseStack.pushPose();
		poseStack.translate(i, j, k);
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(xScale, yScale, zScale);
		poseStack.translate(offset.x(), offset.y(), offset.z());
		RenderSystem.setShaderColor((color >> 16 & 255) / 255.0F, (color >> 8 & 255) / 255.0F, (color & 255) / 255.0F, (color >>> 24) / 255.0F);
		vertexBuffer.bind();
		Matrix4f matrix4f = poseStack.last().pose();
		vertexBuffer.drawWithShader(matrix4f, projectionMatrix, vertexBuffer.getFormat().hasUV(0) ? GameRenderer.getPositionTexColorShader() : GameRenderer.getPositionColorShader());
		VertexBuffer.unbind();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void renderLevel(RenderLevelStageEvent event) {
		poseStack = event.getPoseStack();
		projectionMatrix = event.getProjectionMatrix();
		partialTick = event.getPartialTick();
		ticks = event.getRenderTick();
		if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_SKY) {
			currentStage = 1;
			RenderSystem.depthMask(false);
			renderShapes(event);
			RenderSystem.enableCull();
			RenderSystem.depthMask(true);
		} else if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
			currentStage = 2;
			RenderSystem.depthMask(true);
			renderShapes(event);
			RenderSystem.enableCull();
			RenderSystem.depthMask(true);
		}
		currentStage = 0;
	}

	private static void renderShapes(Event event) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 pos = entity.getPosition(partialTick);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			execute(event, level, partialTick, ticks);
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.defaultBlendFunc();
			RenderSystem.disableBlend();
			RenderSystem.enableDepthTest();
		}
	}

	public static void execute(LevelAccessor world, double partialTick, double ticks) {
		execute(null, world, partialTick, ticks);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double partialTick, double ticks) {
		double nb = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		double l = 0;
		double nb2 = 0;
		double nb3 = 0;
		if (world instanceof ClientLevel) {
			for (Entity entityiterator : ((ClientLevel) world).entitiesForRendering()) {
				if (entityiterator instanceof FireflyEntity) {
					if (begin(VertexFormat.Mode.QUADS, false, false)) {
						for (int index0 = 0; index0 < 90; index0++) {
							for (int index1 = 0; index1 < 45; index1++) {
								k = 255 - (j / 180) * 95;
								l = 255 - ((j + 4) / 180) * 95;
								add((Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(j)) * 0.5), (Math.cos(Math.toRadians(j)) * 0.5), (Math.cos(Math.toRadians(i)) * Math.sin(Math.toRadians(j)) * 0.5), 0.0F, 0.0F,
										255 << 24 | 255 << 16 | 255 << 8 | 255);
								add((Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(j + 4)) * 0.5), (Math.cos(Math.toRadians(j + 4)) * 0.5), (Math.cos(Math.toRadians(i)) * Math.sin(Math.toRadians(j + 4)) * 0.5), 0.0F, 0.0F,
										255 << 24 | 255 << 16 | 255 << 8 | 255);
								add((Math.sin(Math.toRadians(i + 4)) * Math.sin(Math.toRadians(j + 4)) * 0.5), (Math.cos(Math.toRadians(j + 4)) * 0.5), (Math.cos(Math.toRadians(i + 4)) * Math.sin(Math.toRadians(j + 4)) * 0.5), 0.0F, 0.0F,
										255 << 24 | 255 << 16 | 255 << 8 | 255);
								add((Math.sin(Math.toRadians(i + 4)) * Math.sin(Math.toRadians(j)) * 0.5), (Math.cos(Math.toRadians(j)) * 0.5), (Math.cos(Math.toRadians(i + 4)) * Math.sin(Math.toRadians(j)) * 0.5), 0.0F, 0.0F,
										255 << 24 | 255 << 16 | 255 << 8 | 255);
								j = j + 4;
							}
							j = 0;
							i = i + 4;
						}
						i = 0;
						end();
					}
					if (target(2)) {
						nb = entityiterator.getBbHeight() * 0.4 + Math.cos((ticks + partialTick) * 0.6) * entityiterator.getBbHeight() * 0.35;
						nb2 = 7;
						nb3 = 250;
						for (int index2 = 0; index2 < 25; index2++) {
							renderShape((shape()), (entityiterator.getPosition((float) partialTick).x() - entityiterator.getViewVector((float) partialTick).x() * entityiterator.getBbWidth() * 0.4),
									(entityiterator.getPosition((float) partialTick).y() + entityiterator.getBbHeight() * (entityiterator instanceof LivingEntity _livEnt18 && _livEnt18.isBaby() ? 0.5 : 0.25)),
									(entityiterator.getPosition((float) partialTick).z() - entityiterator.getViewVector((float) partialTick).z() * entityiterator.getBbWidth() * 0.4),
									(float) (Minecraft.getInstance().gameRenderer.getMainCamera().getYRot() + 180), (float) (Minecraft.getInstance().gameRenderer.getMainCamera().getXRot() * (-1) + 90), 0, (float) nb, (float) nb, (float) nb,
									(int) Math.round(nb2) << 24 | 255 << 16 | 238 << 8 | (int) nb3);
							nb = nb + entityiterator.getBbHeight() * 0.2;
							nb2 = nb2 - 0.25;
							nb3 = nb3 - 10;
						}
						release();
					}
				}
			}
		}
	}
}
