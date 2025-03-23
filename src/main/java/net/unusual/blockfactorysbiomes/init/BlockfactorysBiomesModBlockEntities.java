
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.block.entity.BushyCoconutLeavesBlockEntity;
import net.unusual.blockfactorysbiomes.BlockfactorysBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class BlockfactorysBiomesModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BlockfactorysBiomesMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> BUSHY_COCONUT_LEAVES = register("bushy_coconut_leaves", BlockfactorysBiomesModBlocks.BUSHY_COCONUT_LEAVES, BushyCoconutLeavesBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
