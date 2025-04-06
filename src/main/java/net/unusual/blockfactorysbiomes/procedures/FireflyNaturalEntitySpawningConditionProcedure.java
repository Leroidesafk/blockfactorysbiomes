package net.unusual.blockfactorysbiomes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FireflyNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7 || world.dayTime() % 24000 >= 12010 && world.dayTime() % 24000 <= 23460) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			return true;
		}
		return false;
	}
}
