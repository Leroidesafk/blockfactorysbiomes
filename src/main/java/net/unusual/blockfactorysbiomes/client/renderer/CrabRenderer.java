
package net.unusual.blockfactorysbiomes.client.renderer;

import net.unusual.blockfactorysbiomes.procedures.CrabModelVisualScaleProcedure;
import net.unusual.blockfactorysbiomes.entity.CrabEntity;
import net.unusual.blockfactorysbiomes.client.model.Modelcrab;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

public class CrabRenderer extends MobRenderer<CrabEntity, Modelcrab<CrabEntity>> {
	public CrabRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcrab(context.bakeLayer(Modelcrab.LAYER_LOCATION)), 0.4f);
	}

	@Override
	protected void scale(CrabEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) CrabModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(CrabEntity entity) {
		return new ResourceLocation("bf_biomes:textures/entities/crab.png");
	}
}
