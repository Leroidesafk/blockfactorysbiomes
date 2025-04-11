package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class FallenCoconutLogBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world.isClientSide())) {
			{
				int _value = Mth.nextInt(RandomSource.create(), 0, 2);
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
