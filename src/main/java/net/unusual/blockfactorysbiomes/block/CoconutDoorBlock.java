
package net.unusual.blockfactorysbiomes.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CoconutDoorBlock extends DoorBlock {
	public CoconutDoorBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape(), BlockSetType.OAK);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
}