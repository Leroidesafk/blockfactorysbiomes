
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.item.RawCrabMeatItem;
import net.unusual.blockfactorysbiomes.item.PinkButterflyItem;
import net.unusual.blockfactorysbiomes.item.OrangeButterflyItem;
import net.unusual.blockfactorysbiomes.item.OpenedCoconutItem;
import net.unusual.blockfactorysbiomes.item.MapleSyrupItem;
import net.unusual.blockfactorysbiomes.item.GreenButterflyItem;
import net.unusual.blockfactorysbiomes.item.FireFlyItemItem;
import net.unusual.blockfactorysbiomes.item.CookedCrabMeatItem;
import net.unusual.blockfactorysbiomes.item.CoconutItemItem;
import net.unusual.blockfactorysbiomes.item.BugNetItem;
import net.unusual.blockfactorysbiomes.item.BlueButterflyItem;
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
	public static final RegistryObject<Item> MAPLE_TRUNK = block(BfBiomesModBlocks.MAPLE_TRUNK);
	public static final RegistryObject<Item> MAPLE_WOOD = block(BfBiomesModBlocks.MAPLE_WOOD);
	public static final RegistryObject<Item> MAPLE_LOG = block(BfBiomesModBlocks.MAPLE_LOG);
	public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = block(BfBiomesModBlocks.STRIPPED_MAPLE_WOOD);
	public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = block(BfBiomesModBlocks.STRIPPED_MAPLE_LOG);
	public static final RegistryObject<Item> MAPLE_PLANKS = block(BfBiomesModBlocks.MAPLE_PLANKS);
	public static final RegistryObject<Item> MAPLE_STAIRS = block(BfBiomesModBlocks.MAPLE_STAIRS);
	public static final RegistryObject<Item> MAPLE_SLAB = block(BfBiomesModBlocks.MAPLE_SLAB);
	public static final RegistryObject<Item> MAPLE_FENCE = block(BfBiomesModBlocks.MAPLE_FENCE);
	public static final RegistryObject<Item> MAPLE_FENCE_GATE = block(BfBiomesModBlocks.MAPLE_FENCE_GATE);
	public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = block(BfBiomesModBlocks.MAPLE_PRESSURE_PLATE);
	public static final RegistryObject<Item> MAPLE_BUTTON = block(BfBiomesModBlocks.MAPLE_BUTTON);
	public static final RegistryObject<Item> MAPLE_DOOR = doubleBlock(BfBiomesModBlocks.MAPLE_DOOR);
	public static final RegistryObject<Item> COCONUT_TRAPDOOR = block(BfBiomesModBlocks.COCONUT_TRAPDOOR);
	public static final RegistryObject<Item> MAPLE_TRAPDOOR = block(BfBiomesModBlocks.MAPLE_TRAPDOOR);
	public static final RegistryObject<Item> MAPLE_GRASS = block(BfBiomesModBlocks.MAPLE_GRASS);
	public static final RegistryObject<Item> TALL_MAPLE_GRASS = doubleBlock(BfBiomesModBlocks.TALL_MAPLE_GRASS);
	public static final RegistryObject<Item> MAPLE_BUSH = block(BfBiomesModBlocks.MAPLE_BUSH);
	public static final RegistryObject<Item> MAPLE_SAPLING = block(BfBiomesModBlocks.MAPLE_SAPLING);
	public static final RegistryObject<Item> FALLEN_MAPLE_LOG = block(BfBiomesModBlocks.FALLEN_MAPLE_LOG);
	public static final RegistryObject<Item> FALLEN_OVERGROWN_MAPLE_LOG = block(BfBiomesModBlocks.FALLEN_OVERGROWN_MAPLE_LOG);
	public static final RegistryObject<Item> MAPLE_LOG_PILE = block(BfBiomesModBlocks.MAPLE_LOG_PILE);
	public static final RegistryObject<Item> COCONUT_LOG_PILE = block(BfBiomesModBlocks.COCONUT_LOG_PILE);
	public static final RegistryObject<Item> BAOBAB_TRUNK = block(BfBiomesModBlocks.BAOBAB_TRUNK);
	public static final RegistryObject<Item> BAOBAB_WOOD = block(BfBiomesModBlocks.BAOBAB_WOOD);
	public static final RegistryObject<Item> BAOBAB_LOG = block(BfBiomesModBlocks.BAOBAB_LOG);
	public static final RegistryObject<Item> STRIPPED_BAOBAB_WOOD = block(BfBiomesModBlocks.STRIPPED_BAOBAB_WOOD);
	public static final RegistryObject<Item> STRIPPED_BAOBAB_LOG = block(BfBiomesModBlocks.STRIPPED_BAOBAB_LOG);
	public static final RegistryObject<Item> BAOBAB_PLANKS = block(BfBiomesModBlocks.BAOBAB_PLANKS);
	public static final RegistryObject<Item> BAOBAB_STAIRS = block(BfBiomesModBlocks.BAOBAB_STAIRS);
	public static final RegistryObject<Item> BAOBAB_SLAB = block(BfBiomesModBlocks.BAOBAB_SLAB);
	public static final RegistryObject<Item> BAOBAB_FENCE = block(BfBiomesModBlocks.BAOBAB_FENCE);
	public static final RegistryObject<Item> BAOBAB_FENCE_GATE = block(BfBiomesModBlocks.BAOBAB_FENCE_GATE);
	public static final RegistryObject<Item> BAOBAB_PRESSURE_PLATE = block(BfBiomesModBlocks.BAOBAB_PRESSURE_PLATE);
	public static final RegistryObject<Item> BAOBAB_BUTTON = block(BfBiomesModBlocks.BAOBAB_BUTTON);
	public static final RegistryObject<Item> DRIPING_MAPLE_LOG = block(BfBiomesModBlocks.DRIPING_MAPLE_LOG);
	public static final RegistryObject<Item> BAOBAB_DOOR = doubleBlock(BfBiomesModBlocks.BAOBAB_DOOR);
	public static final RegistryObject<Item> BAOBAB_TRAPDOOR = block(BfBiomesModBlocks.BAOBAB_TRAPDOOR);
	public static final RegistryObject<Item> BAOBAB_BUSH = block(BfBiomesModBlocks.BAOBAB_BUSH);
	public static final RegistryObject<Item> BAOBAB_SAPLING = block(BfBiomesModBlocks.BAOBAB_SAPLING);
	public static final RegistryObject<Item> FALLEN_BAOBAB_LOG = block(BfBiomesModBlocks.FALLEN_BAOBAB_LOG);
	public static final RegistryObject<Item> FALLEN_OVERGROWN_BAOBAB_LOG = block(BfBiomesModBlocks.FALLEN_OVERGROWN_BAOBAB_LOG);
	public static final RegistryObject<Item> BAOBAB_LOG_PILE = block(BfBiomesModBlocks.BAOBAB_LOG_PILE);
	public static final RegistryObject<Item> BUSHY_MAPLE_LEAVES = block(BfBiomesModBlocks.BUSHY_MAPLE_LEAVES);
	public static final RegistryObject<Item> SQUIRREL_SPAWN_EGG = REGISTRY.register("squirrel_spawn_egg", () -> new ForgeSpawnEggItem(BfBiomesModEntities.SQUIRREL, -6723269, -2835818, new Item.Properties()));
	public static final RegistryObject<Item> MAPLE_LEAVES = block(BfBiomesModBlocks.MAPLE_LEAVES);
	public static final RegistryObject<Item> BAOBAB_LEAVES = block(BfBiomesModBlocks.BAOBAB_LEAVES);
	public static final RegistryObject<Item> BUSHY_BAOBAB_LEAVES = block(BfBiomesModBlocks.BUSHY_BAOBAB_LEAVES);
	public static final RegistryObject<Item> GREEN_BUTTERFLY = REGISTRY.register("green_butterfly", () -> new GreenButterflyItem());
	public static final RegistryObject<Item> BLUE_BUTTERFLY = REGISTRY.register("blue_butterfly", () -> new BlueButterflyItem());
	public static final RegistryObject<Item> ORANGE_BUTTERFLY = REGISTRY.register("orange_butterfly", () -> new OrangeButterflyItem());
	public static final RegistryObject<Item> PRICKLY_CACTUS = block(BfBiomesModBlocks.PRICKLY_CACTUS);
	public static final RegistryObject<Item> PINK_BUTTERFLY = REGISTRY.register("pink_butterfly", () -> new PinkButterflyItem());
	public static final RegistryObject<Item> BUG_NET = REGISTRY.register("bug_net", () -> new BugNetItem());
	public static final RegistryObject<Item> DRY_SOIL = block(BfBiomesModBlocks.DRY_SOIL);
	public static final RegistryObject<Item> FLOWERING_URCHIN_CACTUS = block(BfBiomesModBlocks.FLOWERING_URCHIN_CACTUS);
	public static final RegistryObject<Item> FIRE_FLY_ITEM = REGISTRY.register("fire_fly_item", () -> new FireFlyItemItem());
	public static final RegistryObject<Item> DEER_SPAWN_EGG = REGISTRY.register("deer_spawn_egg", () -> new ForgeSpawnEggItem(BfBiomesModEntities.DEER, -5209270, -1456490, new Item.Properties()));
	public static final RegistryObject<Item> MAPLE_SYRUP = REGISTRY.register("maple_syrup", () -> new MapleSyrupItem());
	public static final RegistryObject<Item> RED_AUTUMN_GRASS = block(BfBiomesModBlocks.RED_AUTUMN_GRASS);
	public static final RegistryObject<Item> BUTTERFLY_SPAWN_EGG = REGISTRY.register("butterfly_spawn_egg", () -> new ForgeSpawnEggItem(BfBiomesModEntities.BUTTERFLY, -2526191, -14805231, new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_MAPLE_LEAVES = block(BfBiomesModBlocks.FALLEN_MAPLE_LEAVES);
	public static final RegistryObject<Item> FALLEN_MAPLE_BRANCH = block(BfBiomesModBlocks.FALLEN_MAPLE_BRANCH);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
