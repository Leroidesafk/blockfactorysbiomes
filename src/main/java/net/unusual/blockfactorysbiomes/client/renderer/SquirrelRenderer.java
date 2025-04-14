
package net.unusual.blockfactorysbiomes.client.renderer;

public class SquirrelRenderer extends MobRenderer<SquirrelEntity, Modelsquirrel<SquirrelEntity>> {

	public SquirrelRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsquirrel(context.bakeLayer(Modelsquirrel.LAYER_LOCATION)), 0.4f);

	}

	@Override
	protected void scale(SquirrelEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float)

		CrabModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(SquirrelEntity entity) {
		return new ResourceLocation("bf_biomes:textures/entities/squirrel.png");
	}

}
