
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.block.HangingCoconutLeavesBlock;
import net.unusual.blockfactorysbiomes.block.CoconutWoodBlock;
import net.unusual.blockfactorysbiomes.block.CoconutTrunkBlock;
import net.unusual.blockfactorysbiomes.block.CoconutStairsBlock;
import net.unusual.blockfactorysbiomes.block.CoconutSlabBlock;
import net.unusual.blockfactorysbiomes.block.CoconutPressurePlateBlock;
import net.unusual.blockfactorysbiomes.block.CoconutPlanksBlock;
import net.unusual.blockfactorysbiomes.block.CoconutLogBlock;
import net.unusual.blockfactorysbiomes.block.CoconutLeavesBlock;
import net.unusual.blockfactorysbiomes.block.CoconutFenceGateBlock;
import net.unusual.blockfactorysbiomes.block.CoconutFenceBlock;
import net.unusual.blockfactorysbiomes.block.CoconutDoorBlock;
import net.unusual.blockfactorysbiomes.block.CoconutButtonBlock;
import net.unusual.blockfactorysbiomes.block.CoconutBlock;
import net.unusual.blockfactorysbiomes.block.BushyCoconutLeavesBlock;
import net.unusual.blockfactorysbiomes.BlockfactorysBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class BlockfactorysBiomesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BlockfactorysBiomesMod.MODID);
	public static final RegistryObject<Block> COCONUT_TRUNK = REGISTRY.register("coconut_trunk", () -> new CoconutTrunkBlock());
	public static final RegistryObject<Block> COCONUT_WOOD = REGISTRY.register("coconut_wood", () -> new CoconutWoodBlock());
	public static final RegistryObject<Block> COCONUT_LOG = REGISTRY.register("coconut_log", () -> new CoconutLogBlock());
	public static final RegistryObject<Block> COCONUT_PLANKS = REGISTRY.register("coconut_planks", () -> new CoconutPlanksBlock());
	public static final RegistryObject<Block> COCONUT_LEAVES = REGISTRY.register("coconut_leaves", () -> new CoconutLeavesBlock());
	public static final RegistryObject<Block> COCONUT_STAIRS = REGISTRY.register("coconut_stairs", () -> new CoconutStairsBlock());
	public static final RegistryObject<Block> COCONUT_SLAB = REGISTRY.register("coconut_slab", () -> new CoconutSlabBlock());
	public static final RegistryObject<Block> COCONUT_FENCE = REGISTRY.register("coconut_fence", () -> new CoconutFenceBlock());
	public static final RegistryObject<Block> COCONUT_FENCE_GATE = REGISTRY.register("coconut_fence_gate", () -> new CoconutFenceGateBlock());
	public static final RegistryObject<Block> COCONUT_PRESSURE_PLATE = REGISTRY.register("coconut_pressure_plate", () -> new CoconutPressurePlateBlock());
	public static final RegistryObject<Block> COCONUT_BUTTON = REGISTRY.register("coconut_button", () -> new CoconutButtonBlock());
	public static final RegistryObject<Block> COCONUT_DOOR = REGISTRY.register("coconut_door", () -> new CoconutDoorBlock());
	public static final RegistryObject<Block> COCONUT = REGISTRY.register("coconut", () -> new CoconutBlock());
	public static final RegistryObject<Block> BUSHY_COCONUT_LEAVES = REGISTRY.register("bushy_coconut_leaves", () -> new BushyCoconutLeavesBlock());
	public static final RegistryObject<Block> HANGING_COCONUT_LEAVES = REGISTRY.register("hanging_coconut_leaves", () -> new HangingCoconutLeavesBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
