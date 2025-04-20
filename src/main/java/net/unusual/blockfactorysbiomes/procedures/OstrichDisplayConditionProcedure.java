package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class OstrichDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof OstrichEntity _datEntL0 && _datEntL0.getEntityData().get(OstrichEntity.DATA_has_saddle)) {
			return true;
		}
		return false;
	}
}
