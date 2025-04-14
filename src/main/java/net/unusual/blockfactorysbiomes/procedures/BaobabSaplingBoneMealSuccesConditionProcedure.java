package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BaobabSaplingBoneMealSuccesConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Math.random() < 0.8) {
			return false;
		}
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sy = 0;
			for (int index1 = 0; index1 < 4; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 3; index2++) {
					if (!world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
						if (x != x + sx && y != y + sy && z != z + sz) {
							return false;
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		sx = -6;
		for (int index3 = 0; index3 < 13; index3++) {
			sy = 5;
			for (int index4 = 0; index4 < 15; index4++) {
				sz = -6;
				for (int index5 = 0; index5 < 13; index5++) {
					if (!world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
						return false;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		return true;
	}
}
