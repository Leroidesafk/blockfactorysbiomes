package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class OstrichEggProjectileProjectileHitProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		stack = new ItemStack(BfBiomesModItems.OSTRICH_EGG.get());
		if (world instanceof ServerLevel _level)
			_level.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, stack), (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 3, 0, 0, 0, 0.05);
		if (Math.random() < 0.125) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
								.withSuppressedOutput(),
						"summon bf_biomes:ostrich ~ ~ ~ {Age:-6000}");
		}
		if (!(world.isClientSide())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.destroy_egg")),
							SoundSource.NEUTRAL, (float) 0.5, 3);
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.destroy_egg")), SoundSource.NEUTRAL,
							(float) 0.5, 3, false);
				}
			}
		}
	}
}
