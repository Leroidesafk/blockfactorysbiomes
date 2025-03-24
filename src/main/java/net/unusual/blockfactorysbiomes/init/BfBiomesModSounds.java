
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.BfBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class BfBiomesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BfBiomesMod.MODID);
	public static final RegistryObject<SoundEvent> CRAB_ATTACK = REGISTRY.register("crab_attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "crab_attack")));
	public static final RegistryObject<SoundEvent> CRAB_WALKING = REGISTRY.register("crab_walking", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "crab_walking")));
}
