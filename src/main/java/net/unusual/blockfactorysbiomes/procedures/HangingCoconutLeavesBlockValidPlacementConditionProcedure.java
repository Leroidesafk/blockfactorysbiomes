package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class HangingCoconutLeavesBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == BfBiomesModBlocks.COCONUT_LEAVES.get() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == BfBiomesModBlocks.BUSHY_COCONUT_LEAVES.get()) {
			return true;
		}
		return false;
	}
}
