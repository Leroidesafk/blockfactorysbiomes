package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.entity.ButterflyEntity;

import net.minecraft.world.entity.Entity;

public class ButterflyDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof ButterflyEntity _datEntI ? _datEntI.getEntityData().get(ButterflyEntity.DATA_color) : 0) == 1) {
			return true;
		}
		return false;
	}
}
