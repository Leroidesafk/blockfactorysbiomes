package net.unusual.blockfactorysbiomes.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CoconutNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!((world.getBlockState(BlockPos.containing(x - (new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)).getStepX(), y, z - (new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)).getStepZ()))).is(BlockTags.create(new ResourceLocation("minecraft:logs"))))) {
			if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP)) {
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), (world.getBlockState(BlockPos.containing(x, y, z))));
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
