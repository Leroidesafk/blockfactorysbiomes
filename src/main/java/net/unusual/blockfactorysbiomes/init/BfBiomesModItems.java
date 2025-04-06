
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.item.RawCrabMeatItem;
import net.unusual.blockfactorysbiomes.item.OpenedCoconutItem;
import net.unusual.blockfactorysbiomes.item.CookedCrabMeatItem;
import net.unusual.blockfactorysbiomes.item.CoconutItemItem;
import net.unusual.blockfactorysbiomes.BfBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

public class BfBiomesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BfBiomesMod.MODID);
	public static final RegistryObject<Item> COCONUT_TRUNK = block(BfBiomesModBlocks.COCONUT_TRUNK);
	public static final RegistryObject<Item> COCONUT_WOOD = block(BfBiomesModBlocks.COCONUT_WOOD);
	public static final RegistryObject<Item> COCONUT_LOG = block(BfBiomesModBlocks.COCONUT_LOG);
	public static final RegistryObject<Item> COCONUT_PLANKS = block(BfBiomesModBlocks.COCONUT_PLANKS);
	public static final RegistryObject<Item> COCONUT_LEAVES = block(BfBiomesModBlocks.COCONUT_LEAVES);
	public static final RegistryObject<Item> COCONUT_STAIRS = block(BfBiomesModBlocks.COCONUT_STAIRS);
	public static final RegistryObject<Item> COCONUT_SLAB = block(BfBiomesModBlocks.COCONUT_SLAB);
	public static final RegistryObject<Item> COCONUT_FENCE = block(BfBiomesModBlocks.COCONUT_FENCE);
	public static final RegistryObject<Item> COCONUT_FENCE_GATE = block(BfBiomesModBlocks.COCONUT_FENCE_GATE);
	public static final RegistryObject<Item> COCONUT_PRESSURE_PLATE = block(BfBiomesModBlocks.COCONUT_PRESSURE_PLATE);
	public static final RegistryObject<Item> COCONUT_BUTTON = block(BfBiomesModBlocks.COCONUT_BUTTON);
	public static final RegistryObject<Item> COCONUT_DOOR = doubleBlock(BfBiomesModBlocks.COCONUT_DOOR);
	public static final RegistryObject<Item> CRAB_SPAWN_EGG = REGISTRY.register("crab_spawn_egg", () -> new ForgeSpawnEggItem(BfBiomesModEntities.CRAB, -3725038, -4226725, new Item.Properties()));
	public static final RegistryObject<Item> COCONUT = block(BfBiomesModBlocks.COCONUT);
	public static final RegistryObject<Item> OPENED_COCONUT = REGISTRY.register("opened_coconut", () -> new OpenedCoconutItem());
	public static final RegistryObject<Item> COCONUT_ITEM = REGISTRY.register("coconut_item", () -> new CoconutItemItem());
	public static final RegistryObject<Item> BUSHY_COCONUT_LEAVES = block(BfBiomesModBlocks.BUSHY_COCONUT_LEAVES);
	public static final RegistryObject<Item> HANGING_COCONUT_LEAVES = block(BfBiomesModBlocks.HANGING_COCONUT_LEAVES);
	public static final RegistryObject<Item> LONG_SHELL = block(BfBiomesModBlocks.LONG_SHELL);
	public static final RegistryObject<Item> ROUND_SHELL = block(BfBiomesModBlocks.ROUND_SHELL);
	public static final RegistryObject<Item> ZIGAG_SHELL = block(BfBiomesModBlocks.ZIGAG_SHELL);
	public static final RegistryObject<Item> BLUE_LION_PAW_SEASHELL = block(BfBiomesModBlocks.BLUE_LION_PAW_SEASHELL);
	public static final RegistryObject<Item> PINK_LION_PAW_SEASHEL = block(BfBiomesModBlocks.PINK_LION_PAW_SEASHEL);
	public static final RegistryObject<Item> FALLEN_COCONUT_LOG = block(BfBiomesModBlocks.FALLEN_COCONUT_LOG);
	public static final RegistryObject<Item> FALLEN_OVERGROWN_COCONUT_LOG = block(BfBiomesModBlocks.FALLEN_OVERGROWN_COCONUT_LOG);
	public static final RegistryObject<Item> LOG_PILE = block(BfBiomesModBlocks.LOG_PILE);
	public static final RegistryObject<Item> STARFISH = block(BfBiomesModBlocks.STARFISH);
	public static final RegistryObject<Item> COCONUT_BUSH = block(BfBiomesModBlocks.COCONUT_BUSH);
	public static final RegistryObject<Item> FIREFLY_SPAWN_EGG = REGISTRY.register("firefly_spawn_egg", () -> new ForgeSpawnEggItem(BfBiomesModEntities.FIREFLY, -10995188, -917659, new Item.Properties()));
	public static final RegistryObject<Item> DRIED_GRASS = block(BfBiomesModBlocks.DRIED_GRASS);
	public static final RegistryObject<Item> TALL_DRIED_GRASS = doubleBlock(BfBiomesModBlocks.TALL_DRIED_GRASS);
	public static final RegistryObject<Item> DEAD_GRASS = block(BfBiomesModBlocks.DEAD_GRASS);
	public static final RegistryObject<Item> TALL_DEAD_GRASS = doubleBlock(BfBiomesModBlocks.TALL_DEAD_GRASS);
	public static final RegistryObject<Item> COCONUT_SAPLING = block(BfBiomesModBlocks.COCONUT_SAPLING);
	public static final RegistryObject<Item> STRIPPED_COCONUT_WOOD = block(BfBiomesModBlocks.STRIPPED_COCONUT_WOOD);
	public static final RegistryObject<Item> STRIPPED_COCONUT_LOG = block(BfBiomesModBlocks.STRIPPED_COCONUT_LOG);
	public static final RegistryObject<Item> RAW_CRAB_MEAT = REGISTRY.register("raw_crab_meat", () -> new RawCrabMeatItem());
	public static final RegistryObject<Item> COOKED_CRAB_MEAT = REGISTRY.register("cooked_crab_meat", () -> new CookedCrabMeatItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
