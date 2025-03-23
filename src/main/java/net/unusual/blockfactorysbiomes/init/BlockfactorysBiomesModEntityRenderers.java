
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.client.renderer.CrabRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockfactorysBiomesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BlockfactorysBiomesModEntities.NULL_PR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(BlockfactorysBiomesModEntities.CRAB.get(), CrabRenderer::new);
	}
}
