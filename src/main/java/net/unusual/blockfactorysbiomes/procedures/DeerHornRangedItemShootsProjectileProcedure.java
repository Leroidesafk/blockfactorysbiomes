package net.unusual.blockfactorysbiomes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class DeerHornRangedItemShootsProjectileProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("efefefef"), false);
	}
}
