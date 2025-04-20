
package net.unusual.blockfactorysbiomes.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DaisyBlock extends FlowerBlock {
	public DaisyBlock() {
		super(() -> MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(2, 0, 2, 14, 13, 14).move(offset.x, offset.y, offset.z);
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
}