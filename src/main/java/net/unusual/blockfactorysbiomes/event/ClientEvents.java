
package net.mcreator.blockfactorysbiomes.events;

import net.unusual.blockfactorysbiomes.client.renderer.CopperFirstPersonRenderer;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;

@EventBusSubscriber(Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void onTick(ClientTickEvent event) {
		if (!isGameActive())
			return;
		CopperFirstPersonRenderer.clientTick();
	}

	protected static boolean isGameActive() {
		return !(Minecraft.getInstance().level == null || Minecraft.getInstance().player == null);
	}
}
