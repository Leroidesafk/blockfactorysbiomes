
package net.unusual.blockfactorysbiomes.client.renderer;

import net.unusual.blockfactorysbiomes.procedures.CrabModelVisualScaleProcedure;
import net.unusual.blockfactorysbiomes.procedures.ButterflyDisplayConditionProcedure;
import net.unusual.blockfactorysbiomes.procedures.ButterflyDisplayCondition3Procedure;
import net.unusual.blockfactorysbiomes.procedures.ButterflyDisplayCondition2Procedure;
import net.unusual.blockfactorysbiomes.entity.ButterflyEntity;
import net.unusual.blockfactorysbiomes.client.model.Modelbutterfly;

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

public class ButterflyRenderer extends MobRenderer<ButterflyEntity, Modelbutterfly<ButterflyEntity>> {
	public ButterflyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbutterfly(context.bakeLayer(Modelbutterfly.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<ButterflyEntity, Modelbutterfly<ButterflyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("bf_biomes:textures/entities/butterfly_blue.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ButterflyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ButterflyDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<ButterflyEntity, Modelbutterfly<ButterflyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("bf_biomes:textures/entities/butterfly_green.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ButterflyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ButterflyDisplayCondition2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<ButterflyEntity, Modelbutterfly<ButterflyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("bf_biomes:textures/entities/butterfly_pink.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ButterflyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ButterflyDisplayCondition3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	protected void scale(ButterflyEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) CrabModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(ButterflyEntity entity) {
		return new ResourceLocation("bf_biomes:textures/entities/butterfly.png");
	}
}
