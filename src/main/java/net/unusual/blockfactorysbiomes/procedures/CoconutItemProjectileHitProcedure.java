package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.BlockPos;

public class CoconutItemProjectileHitProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		ItemStack coconut = ItemStack.EMPTY;
		ItemStack stack = ItemStack.EMPTY;
		stack = new ItemStack(BfBiomesModItems.COCONUT_ITEM.get());
		coconut = new ItemStack(BfBiomesModItems.OPENED_COCONUT.get());
		coconut.setCount(2);
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), coconut);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, stack), (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 3, 0, 0, 0, 0.05);
		if (!(world.isClientSide())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
							SoundSource.NEUTRAL, (float) 0.5, 3);
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.NEUTRAL,
							(float) 0.5, 3, false);
				}
			}
		}
	}
}
