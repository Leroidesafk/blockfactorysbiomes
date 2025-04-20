package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class FallenBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			stack = (new ItemStack(blockstate.getBlock()));
			stack.setCount(blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip4 ? blockstate.getValue(_getip4) : -1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), stack);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
