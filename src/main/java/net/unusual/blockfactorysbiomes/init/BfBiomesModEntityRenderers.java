
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.client.renderer.SquirrelRenderer;
import net.unusual.blockfactorysbiomes.client.renderer.FireflyRenderer;
import net.unusual.blockfactorysbiomes.client.renderer.CrabRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BfBiomesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BfBiomesModEntities.NULL_PR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(BfBiomesModEntities.CRAB.get(), CrabRenderer::new);
		event.registerEntityRenderer(BfBiomesModEntities.COCONUT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(BfBiomesModEntities.FIREFLY.get(), FireflyRenderer::new);
		event.registerEntityRenderer(BfBiomesModEntities.SQUIRREL.get(), SquirrelRenderer::new);
	}
}
