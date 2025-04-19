package net.unusual.blockfactorysbiomes.procedures;

public class MapleAdditionalParticleExpiryConditionProcedure {
	public static boolean execute(boolean onGround) {
		if (onGround) {
			return true;
		}
		return false;
	}
}
