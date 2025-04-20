package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class OstrichMoveConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) > 0) {
			return false;
		}
		return true;
	}
}
