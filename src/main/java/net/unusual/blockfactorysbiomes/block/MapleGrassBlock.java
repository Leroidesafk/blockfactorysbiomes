
package net.unusual.blockfactorysbiomes.block;

import net.unusual.blockfactorysbiomes.procedures.DriedGrassCanBoneMealBeUsedOnThisBlockProcedure;
import net.unusual.blockfactorysbiomes.procedures.DeadGrassOnBoneMealSuccessProcedure;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MapleGrassBlock extends FlowerBlock implements BonemealableBlock {
	public MapleGrassBlock() {
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

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return DriedGrassCanBoneMealBeUsedOnThisBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		DeadGrassOnBoneMealSuccessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
