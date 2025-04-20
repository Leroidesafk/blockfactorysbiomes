
package net.unusual.blockfactorysbiomes.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GreenButterflyJarBlock extends FallingBlock {
	public GreenButterflyJarBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).sound(SoundType.GLASS).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
		return Shapes.or(box(4, 0, 4, 12, 9, 12), box(5, 9, 5, 11, 10, 11));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		GreenButterflyJarBlockDestroyedByPlayerProcedure.execute();
		return retval;
	}
}