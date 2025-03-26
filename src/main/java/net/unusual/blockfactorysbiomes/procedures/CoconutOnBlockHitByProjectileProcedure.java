package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModEntities;
import net.unusual.blockfactorysbiomes.entity.CoconutProjectileEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class CoconutOnBlockHitByProjectileProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double hitX, double hitY, double hitZ) {
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, float damage, int knockback) {
					AbstractArrow entityToSpawn = new CoconutProjectileEntity(BfBiomesModEntities.COCONUT_PROJECTILE.get(), level);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, 1, 1);
			_entityToSpawn.setPos(hitX, hitY, hitZ);
			_entityToSpawn.shoot(0, 0, 0, (float) 0.2, 3);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
