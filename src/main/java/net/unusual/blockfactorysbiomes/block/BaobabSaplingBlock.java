
package net.unusual.blockfactorysbiomes.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BaobabSaplingBlock extends FlowerBlock implements BonemealableBlock {
	public BaobabSaplingBlock() {
		super(() -> MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().sound(SoundType.GRASS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		BaobabSaplingOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return BaobabSaplingBoneMealSuccesConditionProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		BaobabSaplingOnBoneMealSuccesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}