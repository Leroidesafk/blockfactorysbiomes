package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SquirrelEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SquirrelEntity _datEntSetL)
			_datEntSetL.getEntityData().set(SquirrelEntity.DATA_is_climbing, false);
	}
}
