package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

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
