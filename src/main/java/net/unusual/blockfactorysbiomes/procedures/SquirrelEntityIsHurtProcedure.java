package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.entity.SquirrelEntity;

import net.minecraft.world.entity.Entity;

public class SquirrelEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SquirrelEntity _datEntSetL)
			_datEntSetL.getEntityData().set(SquirrelEntity.DATA_is_climbing, false);
	}
}
