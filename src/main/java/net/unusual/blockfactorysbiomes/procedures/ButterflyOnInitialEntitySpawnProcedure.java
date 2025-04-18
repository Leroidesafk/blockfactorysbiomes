package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

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
