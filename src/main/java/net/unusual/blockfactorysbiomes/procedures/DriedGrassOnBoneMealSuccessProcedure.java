package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DriedGrassOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
			public BlockState with(BlockState _bs, String _property, String _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
			}
		}.with(BfBiomesModBlocks.TALL_DRIED_GRASS.get().defaultBlockState(), "half", "upper")), 3);
		world.setBlock(BlockPos.containing(x, y, z), (new Object() {
			public BlockState with(BlockState _bs, String _property, String _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
			}
		}.with(BfBiomesModBlocks.TALL_DRIED_GRASS.get().defaultBlockState(), "half", "bottom")), 3);
	}
}
