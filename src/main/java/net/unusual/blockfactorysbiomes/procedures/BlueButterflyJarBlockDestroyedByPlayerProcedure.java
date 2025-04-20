package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BlueButterflyJarBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = BfBiomesModEntities.BUTTERFLY.get().spawn(_serverLevel, BlockPos.containing((x + 0.5), (y + 0.25), (z + 0.5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			if ((entitytospawn) instanceof ButterflyEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ButterflyEntity.DATA_color, 1);
		}
	}
}
