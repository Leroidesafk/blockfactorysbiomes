
package net.unusual.blockfactorysbiomes.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CoconutLogPileBlock extends FallingBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CoconutLogPileBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(11, 0, 1, 15, 4, 16), box(2, 0, 0, 7, 5, 16), box(8, 4, 0, 12, 8, 15), box(7, 0, 3, 11, 4, 15), box(4, 4, 1, 8, 8, 14), box(6, 8, 1, 10, 12, 16));
			case NORTH -> Shapes.or(box(1, 0, 0, 5, 4, 15), box(9, 0, 0, 14, 5, 16), box(4, 4, 1, 8, 8, 16), box(5, 0, 1, 9, 4, 13), box(8, 4, 2, 12, 8, 15), box(6, 8, 0, 10, 12, 15));
			case EAST -> Shapes.or(box(1, 0, 1, 16, 4, 5), box(0, 0, 9, 16, 5, 14), box(0, 4, 4, 15, 8, 8), box(3, 0, 5, 15, 4, 9), box(1, 4, 8, 14, 8, 12), box(1, 8, 6, 16, 12, 10));
			case WEST -> Shapes.or(box(0, 0, 11, 15, 4, 15), box(0, 0, 2, 16, 5, 7), box(1, 4, 8, 16, 8, 12), box(1, 0, 7, 13, 4, 11), box(2, 4, 4, 15, 8, 8), box(0, 8, 6, 15, 12, 10));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
}
