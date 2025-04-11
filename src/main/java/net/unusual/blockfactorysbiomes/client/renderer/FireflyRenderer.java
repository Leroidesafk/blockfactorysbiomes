
package net.unusual.blockfactorysbiomes.client.renderer;

import net.unusual.blockfactorysbiomes.procedures.CrabModelVisualScaleProcedure;
import net.unusual.blockfactorysbiomes.entity.FireflyEntity;
import net.unusual.blockfactorysbiomes.client.model.Modelfirefly;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FireflyRenderer extends MobRenderer<FireflyEntity, Modelfirefly<FireflyEntity>> {
	public FireflyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirefly(context.bakeLayer(Modelfirefly.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FireflyEntity, Modelfirefly<FireflyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("bf_biomes:textures/entities/firefly_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FireflyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 15728880, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
		this.addLayer(new RenderLayer<FireflyEntity, Modelfirefly<FireflyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("bf_biomes:textures/entities/firefly_wing.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FireflyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucentCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(FireflyEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) CrabModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(FireflyEntity entity) {
		return new ResourceLocation("bf_biomes:textures/entities/firefly.png");
	}
}
