
package net.unusual.blockfactorysbiomes.client.renderer;

import net.unusual.blockfactorysbiomes.procedures.OstrichDisplayConditionProcedure;
import net.unusual.blockfactorysbiomes.procedures.CrabModelVisualScaleProcedure;
import net.unusual.blockfactorysbiomes.entity.OstrichEntity;
import net.unusual.blockfactorysbiomes.client.model.Modelostrich;

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

public class OstrichRenderer extends MobRenderer<OstrichEntity, Modelostrich<OstrichEntity>> {
	public OstrichRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelostrich(context.bakeLayer(Modelostrich.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<OstrichEntity, Modelostrich<OstrichEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("bf_biomes:textures/entities/ostrich_saddle.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, OstrichEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (OstrichDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	protected void scale(OstrichEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) CrabModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(OstrichEntity entity) {
		return new ResourceLocation("bf_biomes:textures/entities/ostrich.png");
	}
}
