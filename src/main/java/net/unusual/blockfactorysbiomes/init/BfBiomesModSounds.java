
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
	public static final RegistryObject<SoundEvent> FIREFLY_FLYING = REGISTRY.register("firefly_flying", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "firefly_flying")));
	public static final RegistryObject<SoundEvent> SQUIRREL_CLIMBING = REGISTRY.register("squirrel_climbing", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "squirrel_climbing")));
	public static final RegistryObject<SoundEvent> SQUIRREL_HURT = REGISTRY.register("squirrel_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "squirrel_hurt")));
	public static final RegistryObject<SoundEvent> SQUIRREL_AMBIENT = REGISTRY.register("squirrel_ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "squirrel_ambient")));
	public static final RegistryObject<SoundEvent> SQUIRREL_RUNNING = REGISTRY.register("squirrel_running", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "squirrel_running")));
	public static final RegistryObject<SoundEvent> DEER_WALK = REGISTRY.register("deer_walk", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "deer_walk")));
	public static final RegistryObject<SoundEvent> OSTRICH_SQUEAK = REGISTRY.register("ostrich_squeak", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "ostrich_squeak")));
	public static final RegistryObject<SoundEvent> DEER_CALL = REGISTRY.register("deer_call", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "deer_call")));
	public static final RegistryObject<SoundEvent> FOREST_LOOT = REGISTRY.register("forest_loot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "forest_loot")));
	public static final RegistryObject<SoundEvent> OSTRICH_WALK = REGISTRY.register("ostrich_walk", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bf_biomes", "ostrich_walk")));
}
