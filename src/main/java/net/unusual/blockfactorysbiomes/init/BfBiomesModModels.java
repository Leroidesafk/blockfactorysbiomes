
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.client.model.Modelsquirrel;
import net.unusual.blockfactorysbiomes.client.model.Modelostrich;
import net.unusual.blockfactorysbiomes.client.model.Modelfirefly;
import net.unusual.blockfactorysbiomes.client.model.Modeldeer;
import net.unusual.blockfactorysbiomes.client.model.Modelcrab;
import net.unusual.blockfactorysbiomes.client.model.Modelcopper_armor;
import net.unusual.blockfactorysbiomes.client.model.Modelbutterfly;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BfBiomesModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelbutterfly.LAYER_LOCATION, Modelbutterfly::createBodyLayer);
		event.registerLayerDefinition(Modelcopper_armor.LAYER_LOCATION, Modelcopper_armor::createBodyLayer);
		event.registerLayerDefinition(Modelostrich.LAYER_LOCATION, Modelostrich::createBodyLayer);
		event.registerLayerDefinition(Modelfirefly.LAYER_LOCATION, Modelfirefly::createBodyLayer);
		event.registerLayerDefinition(Modeldeer.LAYER_LOCATION, Modeldeer::createBodyLayer);
		event.registerLayerDefinition(Modelsquirrel.LAYER_LOCATION, Modelsquirrel::createBodyLayer);
		event.registerLayerDefinition(Modelcrab.LAYER_LOCATION, Modelcrab::createBodyLayer);
	}
}
