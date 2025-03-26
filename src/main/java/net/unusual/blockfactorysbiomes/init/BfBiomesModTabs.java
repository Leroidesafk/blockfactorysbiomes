
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.BfBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class BfBiomesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BfBiomesMod.MODID);
	public static final RegistryObject<CreativeModeTab> BLOCK_FACTORYS_BIOMES_TAB = REGISTRY.register("block_factorys_biomes_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.bf_biomes.block_factorys_biomes_tab")).icon(() -> new ItemStack(BfBiomesModBlocks.COCONUT_TRUNK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BfBiomesModBlocks.COCONUT_TRUNK.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_WOOD.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_LOG.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_LEAVES.get().asItem());
				tabData.accept(BfBiomesModBlocks.BUSHY_COCONUT_LEAVES.get().asItem());
				tabData.accept(BfBiomesModBlocks.HANGING_COCONUT_LEAVES.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_BUSH.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_PLANKS.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_STAIRS.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_SLAB.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_FENCE.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_FENCE_GATE.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_PRESSURE_PLATE.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_BUTTON.get().asItem());
				tabData.accept(BfBiomesModBlocks.COCONUT_DOOR.get().asItem());
				tabData.accept(BfBiomesModItems.CRAB_SPAWN_EGG.get());
				tabData.accept(BfBiomesModBlocks.COCONUT.get().asItem());
				tabData.accept(BfBiomesModItems.OPENED_COCONUT.get());
				tabData.accept(BfBiomesModItems.COCONUT_ITEM.get());
				tabData.accept(BfBiomesModBlocks.LONG_SHELL.get().asItem());
				tabData.accept(BfBiomesModBlocks.ROUND_SHELL.get().asItem());
				tabData.accept(BfBiomesModBlocks.ZIGAG_SHELL.get().asItem());
				tabData.accept(BfBiomesModBlocks.BLUE_LION_PAW_SEASHELL.get().asItem());
				tabData.accept(BfBiomesModBlocks.PINK_LION_PAW_SEASHEL.get().asItem());
				tabData.accept(BfBiomesModBlocks.STARFISH.get().asItem());
				tabData.accept(BfBiomesModBlocks.FALLEN_COCONUT_LOG.get().asItem());
				tabData.accept(BfBiomesModBlocks.FALLEN_OVERGROWN_COCONUT_LOG.get().asItem());
				tabData.accept(BfBiomesModBlocks.LOG_PILE.get().asItem());
			})

					.build());
}
