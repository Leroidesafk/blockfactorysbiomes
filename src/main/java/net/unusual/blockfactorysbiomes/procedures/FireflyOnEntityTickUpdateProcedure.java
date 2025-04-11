package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class FireflyOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.5) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + (entity.getPersistentData().getBoolean("xRdm") ? 0.2 : -0.2)), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
			entity.getPersistentData().putBoolean("xRdm", (!entity.getPersistentData().getBoolean("xRdm")));
		}
		if (Math.random() < 0.5) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + (entity.getPersistentData().getBoolean("yRdm") ? 0.2 : -0.2)), (entity.getDeltaMovement().z())));
			entity.getPersistentData().putBoolean("yRdm", (!entity.getPersistentData().getBoolean("yRdm")));
		}
		if (Math.random() < 0.5) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() + (entity.getPersistentData().getBoolean("zRdm") ? 0.2 : -0.2))));
			entity.getPersistentData().putBoolean("zRdm", (!entity.getPersistentData().getBoolean("zRdm")));
		}
	}
}
