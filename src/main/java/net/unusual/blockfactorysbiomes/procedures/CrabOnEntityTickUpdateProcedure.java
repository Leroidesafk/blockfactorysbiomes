package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.entity.CrabEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class CrabOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof CrabEntity _datEntI ? _datEntI.getEntityData().get(CrabEntity.DATA_attack_animtime) : 0) > 0) {
			if ((entity instanceof CrabEntity _datEntI ? _datEntI.getEntityData().get(CrabEntity.DATA_attack_animtime) : 0) == 13) {
				if (!(world.isClientSide())) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("blockfactorys_biomes:crab_attack")), SoundSource.HOSTILE, 1, 3);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("blockfactorys_biomes:crab_attack")), SoundSource.HOSTILE, 1, 3, false);
						}
					}
				}
			}
			if (entity instanceof CrabEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrabEntity.DATA_attack_animtime, (int) ((entity instanceof CrabEntity _datEntI ? _datEntI.getEntityData().get(CrabEntity.DATA_attack_animtime) : 0) - 1));
			if ((entity instanceof CrabEntity _datEntI ? _datEntI.getEntityData().get(CrabEntity.DATA_attack_animtime) : 0) == 8) {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entity.isAlive()) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
										(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
								entityiterator.setDeltaMovement(
										new Vec3((entityiterator.getDeltaMovement().x() + entity.getLookAngle().x * 0.05), (entityiterator.getDeltaMovement().y() + 0.0125), (entityiterator.getDeltaMovement().z() + entity.getLookAngle().z * 0.05)));
								break;
							}
						}
					}
				}
			}
		} else if ((entity instanceof CrabEntity _datEntI ? _datEntI.getEntityData().get(CrabEntity.DATA_attack_cooldown) : 0) >= 6) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						if (entity instanceof CrabEntity _datEntL31 && _datEntL31.getEntityData().get(CrabEntity.DATA_attack_side)) {
							if (entity instanceof CrabEntity _datEntSetL)
								_datEntSetL.getEntityData().set(CrabEntity.DATA_attack_side, false);
						} else {
							if (entity instanceof CrabEntity _datEntSetL)
								_datEntSetL.getEntityData().set(CrabEntity.DATA_attack_side, true);
						}
						if (entity instanceof CrabEntity _datEntSetI)
							_datEntSetI.getEntityData().set(CrabEntity.DATA_attack_cooldown, 0);
						if (entity instanceof CrabEntity _datEntSetI)
							_datEntSetI.getEntityData().set(CrabEntity.DATA_attack_animtime, 13);
						break;
					}
				}
			}
		} else {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						if (entity instanceof CrabEntity _datEntSetI)
							_datEntSetI.getEntityData().set(CrabEntity.DATA_attack_cooldown, (int) ((entity instanceof CrabEntity _datEntI ? _datEntI.getEntityData().get(CrabEntity.DATA_attack_cooldown) : 0) + 1));
						break;
					}
				}
			}
		}
	}
}
