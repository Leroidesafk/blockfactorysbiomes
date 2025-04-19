package net.unusual.blockfactorysbiomes.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MapleTreeAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.DIRT.defaultBlockState(), 3);
		return true;
	}
}
