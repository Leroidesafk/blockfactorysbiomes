
package net.unusual.blockfactorysbiomes.client.renderer;

import net.unusual.blockfactorysbiomes.entity.DeerEntity;
import net.unusual.blockfactorysbiomes.client.model.Modeldeer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DeerRenderer extends MobRenderer<DeerEntity, Modeldeer<DeerEntity>> {
	public DeerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldeer(context.bakeLayer(Modeldeer.LAYER_LOCATION)), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(DeerEntity entity) {
		return new ResourceLocation("bf_biomes:textures/entities/deer.png");
	}
}
