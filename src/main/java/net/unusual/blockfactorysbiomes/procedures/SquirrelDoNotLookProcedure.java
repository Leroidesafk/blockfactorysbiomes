package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.entity.SquirrelEntity;

import net.minecraft.world.entity.Entity;

public class SquirrelDoNotLookProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof SquirrelEntity _datEntL0 && _datEntL0.getEntityData().get(SquirrelEntity.DATA_is_climbing)) {
			return false;
		}
		return true;
	}
}
