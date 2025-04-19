
package net.unusual.blockfactorysbiomes.block;

import net.unusual.blockfactorysbiomes.init.BfBiomesModParticleTypes;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MapleLeavesBlock extends LeavesBlock {
	public MapleLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.05f).noOcclusion().requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 30;
	}

	public void animateTick(BlockState p_272714_, Level p_272837_, BlockPos p_273218_, RandomSource p_273360_) {
		super.animateTick(p_272714_, p_272837_, p_273218_, p_273360_);
		if (p_273360_.nextInt(10) == 0) {
			BlockPos blockpos = p_273218_.below();
			BlockState blockstate = p_272837_.getBlockState(blockpos);
			if (!isFaceFull(blockstate.getCollisionShape(p_272837_, blockpos), Direction.UP)) {
				p_272837_.addParticle((SimpleParticleType) (BfBiomesModParticleTypes.MAPLE.get()), 
				p_273218_.getX() + 0.5, p_273218_.getY() - 0.5, p_273218_.getZ() + 0.5, 
				(-0.4), (-0.4), (-0.4));
				//ParticleUtils.spawnParticleBelow(p_272837_, p_273218_, p_273360_, BfBiomesModParticleTypes.MAPLE.get());
			}
		}
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().is(ItemTags.create(new ResourceLocation("forge:shears"))))
			return true;
		return false;
	}
}
