package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.entity.ButterflyEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class ButterflyOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(world.isClientSide()) && (true || world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)))) {
			if (entity instanceof ButterflyEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ButterflyEntity.DATA_color, Mth.nextInt(RandomSource.create(), 0, 3));
		}
	}
}
