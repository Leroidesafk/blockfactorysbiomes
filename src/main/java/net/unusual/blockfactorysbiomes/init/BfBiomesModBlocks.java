
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.block.ZigagShellBlock;
import net.unusual.blockfactorysbiomes.block.TallDriedGrassBlock;
import net.unusual.blockfactorysbiomes.block.TallDeadGrassBlock;
import net.unusual.blockfactorysbiomes.block.StrippedMapleWoodBlock;
import net.unusual.blockfactorysbiomes.block.StrippedMapleLogBlock;
import net.unusual.blockfactorysbiomes.block.StrippedCoconutWoodBlock;
import net.unusual.blockfactorysbiomes.block.StrippedCoconutLogBlock;
import net.unusual.blockfactorysbiomes.block.StarfishBlock;
import net.unusual.blockfactorysbiomes.block.RoundShellBlock;
import net.unusual.blockfactorysbiomes.block.PinkLionPawSeashelBlock;
import net.unusual.blockfactorysbiomes.block.MapleWoodBlock;
import net.unusual.blockfactorysbiomes.block.MapleTrunkBlock;
import net.unusual.blockfactorysbiomes.block.MapleTrapdoorBlock;
import net.unusual.blockfactorysbiomes.block.MapleStairsBlock;
import net.unusual.blockfactorysbiomes.block.MapleSlabBlock;
import net.unusual.blockfactorysbiomes.block.MaplePressurePlateBlock;
import net.unusual.blockfactorysbiomes.block.MaplePlanksBlock;
import net.unusual.blockfactorysbiomes.block.MapleLogBlock;
import net.unusual.blockfactorysbiomes.block.MapleFenceGateBlock;
import net.unusual.blockfactorysbiomes.block.MapleFenceBlock;
import net.unusual.blockfactorysbiomes.block.MapleDoorBlock;
import net.unusual.blockfactorysbiomes.block.MapleButtonBlock;
import net.unusual.blockfactorysbiomes.block.LongShellBlock;
import net.unusual.blockfactorysbiomes.block.LogPileBlock;
import net.unusual.blockfactorysbiomes.block.HangingCoconutLeavesBlock;
import net.unusual.blockfactorysbiomes.block.FallenOvergrownCoconutLogBlock;
import net.unusual.blockfactorysbiomes.block.FallenCoconutLogBlock;
import net.unusual.blockfactorysbiomes.block.DriedGrassBlock;
import net.unusual.blockfactorysbiomes.block.DeadGrassBlock;
import net.unusual.blockfactorysbiomes.block.CoconutWoodBlock;
import net.unusual.blockfactorysbiomes.block.CoconutTrunkBlock;
import net.unusual.blockfactorysbiomes.block.CoconutTrapdoorBlock;
import net.unusual.blockfactorysbiomes.block.CoconutStairsBlock;
import net.unusual.blockfactorysbiomes.block.CoconutSlabBlock;
import net.unusual.blockfactorysbiomes.block.CoconutSaplingBlock;
import net.unusual.blockfactorysbiomes.block.CoconutPressurePlateBlock;
import net.unusual.blockfactorysbiomes.block.CoconutPlanksBlock;
import net.unusual.blockfactorysbiomes.block.CoconutLogBlock;
import net.unusual.blockfactorysbiomes.block.CoconutLeavesBlock;
import net.unusual.blockfactorysbiomes.block.CoconutFenceGateBlock;
import net.unusual.blockfactorysbiomes.block.CoconutFenceBlock;
import net.unusual.blockfactorysbiomes.block.CoconutDoorBlock;
import net.unusual.blockfactorysbiomes.block.CoconutButtonBlock;
import net.unusual.blockfactorysbiomes.block.CoconutBushBlock;
import net.unusual.blockfactorysbiomes.block.CoconutBlock;
import net.unusual.blockfactorysbiomes.block.BushyCoconutLeavesBlock;
import net.unusual.blockfactorysbiomes.block.BlueLionPawSeashellBlock;
import net.unusual.blockfactorysbiomes.BfBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class BfBiomesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BfBiomesMod.MODID);
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
	public static final RegistryObject<Block> LONG_SHELL = REGISTRY.register("long_shell", () -> new LongShellBlock());
	public static final RegistryObject<Block> ROUND_SHELL = REGISTRY.register("round_shell", () -> new RoundShellBlock());
	public static final RegistryObject<Block> ZIGAG_SHELL = REGISTRY.register("zigag_shell", () -> new ZigagShellBlock());
	public static final RegistryObject<Block> BLUE_LION_PAW_SEASHELL = REGISTRY.register("blue_lion_paw_seashell", () -> new BlueLionPawSeashellBlock());
	public static final RegistryObject<Block> PINK_LION_PAW_SEASHEL = REGISTRY.register("pink_lion_paw_seashel", () -> new PinkLionPawSeashelBlock());
	public static final RegistryObject<Block> FALLEN_COCONUT_LOG = REGISTRY.register("fallen_coconut_log", () -> new FallenCoconutLogBlock());
	public static final RegistryObject<Block> FALLEN_OVERGROWN_COCONUT_LOG = REGISTRY.register("fallen_overgrown_coconut_log", () -> new FallenOvergrownCoconutLogBlock());
	public static final RegistryObject<Block> LOG_PILE = REGISTRY.register("log_pile", () -> new LogPileBlock());
	public static final RegistryObject<Block> STARFISH = REGISTRY.register("starfish", () -> new StarfishBlock());
	public static final RegistryObject<Block> COCONUT_BUSH = REGISTRY.register("coconut_bush", () -> new CoconutBushBlock());
	public static final RegistryObject<Block> DRIED_GRASS = REGISTRY.register("dried_grass", () -> new DriedGrassBlock());
	public static final RegistryObject<Block> TALL_DRIED_GRASS = REGISTRY.register("tall_dried_grass", () -> new TallDriedGrassBlock());
	public static final RegistryObject<Block> DEAD_GRASS = REGISTRY.register("dead_grass", () -> new DeadGrassBlock());
	public static final RegistryObject<Block> TALL_DEAD_GRASS = REGISTRY.register("tall_dead_grass", () -> new TallDeadGrassBlock());
	public static final RegistryObject<Block> COCONUT_SAPLING = REGISTRY.register("coconut_sapling", () -> new CoconutSaplingBlock());
	public static final RegistryObject<Block> STRIPPED_COCONUT_WOOD = REGISTRY.register("stripped_coconut_wood", () -> new StrippedCoconutWoodBlock());
	public static final RegistryObject<Block> STRIPPED_COCONUT_LOG = REGISTRY.register("stripped_coconut_log", () -> new StrippedCoconutLogBlock());
	public static final RegistryObject<Block> MAPLE_TRUNK = REGISTRY.register("maple_trunk", () -> new MapleTrunkBlock());
	public static final RegistryObject<Block> MAPLE_WOOD = REGISTRY.register("maple_wood", () -> new MapleWoodBlock());
	public static final RegistryObject<Block> MAPLE_LOG = REGISTRY.register("maple_log", () -> new MapleLogBlock());
	public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = REGISTRY.register("stripped_maple_wood", () -> new StrippedMapleWoodBlock());
	public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = REGISTRY.register("stripped_maple_log", () -> new StrippedMapleLogBlock());
	public static final RegistryObject<Block> MAPLE_PLANKS = REGISTRY.register("maple_planks", () -> new MaplePlanksBlock());
	public static final RegistryObject<Block> MAPLE_STAIRS = REGISTRY.register("maple_stairs", () -> new MapleStairsBlock());
	public static final RegistryObject<Block> MAPLE_SLAB = REGISTRY.register("maple_slab", () -> new MapleSlabBlock());
	public static final RegistryObject<Block> MAPLE_FENCE = REGISTRY.register("maple_fence", () -> new MapleFenceBlock());
	public static final RegistryObject<Block> MAPLE_FENCE_GATE = REGISTRY.register("maple_fence_gate", () -> new MapleFenceGateBlock());
	public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = REGISTRY.register("maple_pressure_plate", () -> new MaplePressurePlateBlock());
	public static final RegistryObject<Block> MAPLE_BUTTON = REGISTRY.register("maple_button", () -> new MapleButtonBlock());
	public static final RegistryObject<Block> MAPLE_DOOR = REGISTRY.register("maple_door", () -> new MapleDoorBlock());
	public static final RegistryObject<Block> COCONUT_TRAPDOOR = REGISTRY.register("coconut_trapdoor", () -> new CoconutTrapdoorBlock());
	public static final RegistryObject<Block> MAPLE_TRAPDOOR = REGISTRY.register("maple_trapdoor", () -> new MapleTrapdoorBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
