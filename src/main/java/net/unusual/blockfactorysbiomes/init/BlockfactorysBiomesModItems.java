
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.item.OpenedCoconutItem;
import net.unusual.blockfactorysbiomes.item.CoconutItemItem;
import net.unusual.blockfactorysbiomes.BlockfactorysBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

public class BlockfactorysBiomesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BlockfactorysBiomesMod.MODID);
	public static final RegistryObject<Item> COCONUT_TRUNK = block(BlockfactorysBiomesModBlocks.COCONUT_TRUNK);
	public static final RegistryObject<Item> COCONUT_WOOD = block(BlockfactorysBiomesModBlocks.COCONUT_WOOD);
	public static final RegistryObject<Item> COCONUT_LOG = block(BlockfactorysBiomesModBlocks.COCONUT_LOG);
	public static final RegistryObject<Item> COCONUT_PLANKS = block(BlockfactorysBiomesModBlocks.COCONUT_PLANKS);
	public static final RegistryObject<Item> COCONUT_LEAVES = block(BlockfactorysBiomesModBlocks.COCONUT_LEAVES);
	public static final RegistryObject<Item> COCONUT_STAIRS = block(BlockfactorysBiomesModBlocks.COCONUT_STAIRS);
	public static final RegistryObject<Item> COCONUT_SLAB = block(BlockfactorysBiomesModBlocks.COCONUT_SLAB);
	public static final RegistryObject<Item> COCONUT_FENCE = block(BlockfactorysBiomesModBlocks.COCONUT_FENCE);
	public static final RegistryObject<Item> COCONUT_FENCE_GATE = block(BlockfactorysBiomesModBlocks.COCONUT_FENCE_GATE);
	public static final RegistryObject<Item> COCONUT_PRESSURE_PLATE = block(BlockfactorysBiomesModBlocks.COCONUT_PRESSURE_PLATE);
	public static final RegistryObject<Item> COCONUT_BUTTON = block(BlockfactorysBiomesModBlocks.COCONUT_BUTTON);
	public static final RegistryObject<Item> COCONUT_DOOR = doubleBlock(BlockfactorysBiomesModBlocks.COCONUT_DOOR);
	public static final RegistryObject<Item> CRAB_SPAWN_EGG = REGISTRY.register("crab_spawn_egg", () -> new ForgeSpawnEggItem(BlockfactorysBiomesModEntities.CRAB, -3725038, -4226725, new Item.Properties()));
	public static final RegistryObject<Item> COCONUT = block(BlockfactorysBiomesModBlocks.COCONUT);
	public static final RegistryObject<Item> OPENED_COCONUT = REGISTRY.register("opened_coconut", () -> new OpenedCoconutItem());
	public static final RegistryObject<Item> COCONUT_ITEM = REGISTRY.register("coconut_item", () -> new CoconutItemItem());
	public static final RegistryObject<Item> BUSHY_COCONUT_LEAVES = block(BlockfactorysBiomesModBlocks.BUSHY_COCONUT_LEAVES);
	public static final RegistryObject<Item> HANGING_COCONUT_LEAVES = block(BlockfactorysBiomesModBlocks.HANGING_COCONUT_LEAVES);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
