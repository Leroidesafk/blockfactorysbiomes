package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModItems;
import net.unusual.blockfactorysbiomes.entity.OstrichEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class OstrichOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby())) {
			if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_lay_egg_animtime) : 0) > 0) {
				if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_lay_egg_animtime) : 0) == 26) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX() + entity.getLookAngle().x * (-0.6)), (entity.getY()), (entity.getZ() + entity.getLookAngle().z * (-0.6)), new ItemStack(BfBiomesModItems.OSTRICH_EGG.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.egg")), SoundSource.NEUTRAL, 1, -1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.egg")), SoundSource.NEUTRAL, 1, -1, false);
						}
					}
				}
				if (entity instanceof OstrichEntity _datEntSetI)
					_datEntSetI.getEntityData().set(OstrichEntity.DATA_lay_egg_animtime, (int) ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_lay_egg_animtime) : 0) - 1));
			} else {
				if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_lay_egg_cooldown) : 0) > 6000) {
					if (entity instanceof OstrichEntity _datEntSetI)
						_datEntSetI.getEntityData().set(OstrichEntity.DATA_lay_egg_cooldown, 0);
					if (entity instanceof OstrichEntity _datEntSetI)
						_datEntSetI.getEntityData().set(OstrichEntity.DATA_lay_egg_animtime, 50);
				} else {
					if (entity instanceof OstrichEntity _datEntSetI)
						_datEntSetI.getEntityData().set(OstrichEntity.DATA_lay_egg_cooldown, (int) ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_lay_egg_cooldown) : 0) + 1));
				}
			}
		}
		if (world.getMaxLocalRawBrightness(BlockPos.containing(Math.floor(entity.getX()), Math.floor(entity.getY() + entity.getBbHeight() * 0.75), Math.floor(entity.getZ()))) <= 7
				|| world.dayTime() % 24000 >= 12010 && world.dayTime() % 24000 <= 23460) {
			if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_cooldown) : 0) > 100) {
				if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) < 15) {
					if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) >= 6
							&& (entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) <= 8) {
						world.levelEvent(2001, BlockPos.containing(Math.floor(entity.getX()), Math.floor(entity.getY()) - 1, Math.floor(entity.getZ())),
								Block.getId((world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), Math.floor(entity.getY()) - 1, Math.floor(entity.getZ()))))));
					}
					if (entity instanceof OstrichEntity _datEntSetI)
						_datEntSetI.getEntityData().set(OstrichEntity.DATA_hide_animtime, (int) ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) + 1));
				} else if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) >= 15) {
					if (entity instanceof OstrichEntity _datEntSetI)
						_datEntSetI.getEntityData().set(OstrichEntity.DATA_hide_cooldown, 0);
					if (entity instanceof OstrichEntity _datEntSetL)
						_datEntSetL.getEntityData().set(OstrichEntity.DATA_is_hiding, true);
				}
			} else {
				if (entity instanceof OstrichEntity _datEntSetI)
					_datEntSetI.getEntityData().set(OstrichEntity.DATA_hide_cooldown, (int) ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_cooldown) : 0) + 1));
			}
		} else {
			if (entity instanceof OstrichEntity _datEntSetI)
				_datEntSetI.getEntityData().set(OstrichEntity.DATA_hide_animtime, 0);
			if (entity instanceof OstrichEntity _datEntSetL)
				_datEntSetL.getEntityData().set(OstrichEntity.DATA_is_hiding, false);
		}
		if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 30, false, false));
			if ((entity.getFirstPassenger()) instanceof LivingEntity) {
				(entity.getFirstPassenger()).stopRiding();
			}
		}
	}
}
