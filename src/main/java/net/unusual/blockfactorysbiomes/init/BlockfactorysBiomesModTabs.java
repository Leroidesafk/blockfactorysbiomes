
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.BlockfactorysBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class BlockfactorysBiomesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockfactorysBiomesMod.MODID);
	public static final RegistryObject<CreativeModeTab> BLOCK_FACTORYS_BIOMES_TAB = REGISTRY.register("block_factorys_biomes_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.blockfactorys_biomes.block_factorys_biomes_tab")).icon(() -> new ItemStack(BlockfactorysBiomesModBlocks.COCONUT_TRUNK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_TRUNK.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_WOOD.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_LOG.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_PLANKS.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_LEAVES.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_STAIRS.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_SLAB.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_FENCE.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_FENCE_GATE.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_PRESSURE_PLATE.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_BUTTON.get().asItem());
				tabData.accept(BlockfactorysBiomesModBlocks.COCONUT_DOOR.get().asItem());
				tabData.accept(BlockfactorysBiomesModItems.CRAB_SPAWN_EGG.get());
			})

					.build());
}
