package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SquirrelOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean is_valid = false;
		double rdmX = 0;
		double rdmY = 0;
		double rdmZ = 0;
		double nb = 0;
		if (entity instanceof SquirrelEntity _datEntL0 && _datEntL0.getEntityData().get(SquirrelEntity.DATA_is_climbing)) {
			for (int index0 = 0; index0 < 500; index0++) {
				rdmX = Math.floor(entity.getX()) + Mth.nextInt(RandomSource.create(), -10, 10);
				rdmY = Math.floor(entity.getY()) + Mth.nextInt(RandomSource.create(), -2, 2);
				rdmZ = Math.floor(entity.getZ()) + Mth.nextInt(RandomSource.create(), -10, 10);
				if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY, rdmZ)) && world.getBlockState(BlockPos.containing(rdmX, rdmY - 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY - 1, rdmZ), Direction.UP)) {
					world.setBlock(BlockPos.containing(rdmX, rdmY, rdmZ), Blocks.REDSTONE_BLOCK.defaultBlockState(), 3);
					if (world.getBlockState(BlockPos.containing(rdmX, rdmY + 1, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 1, rdmZ - 1), Direction.NORTH)
							&& world.getBlockState(BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1), Direction.NORTH)
							&& world.getBlockState(BlockPos.containing(rdmX, rdmY, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY, rdmZ + 1), Direction.NORTH)) {
						nb = 3;
						for (int index1 = 0; index1 < 14; index1++) {
							if (world.getBlockState(BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1), Direction.NORTH)
									&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1))) {
								is_valid = true;
								break;
							}
							nb = nb + 1;
						}
					} else if (world.getBlockState(BlockPos.containing(rdmX, rdmY + 1, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 1, rdmZ + 1), Direction.SOUTH)
							&& world.getBlockState(BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1), Direction.SOUTH)
							&& world.getBlockState(BlockPos.containing(rdmX, rdmY, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY, rdmZ + 1), Direction.SOUTH)) {
						nb = 3;
						for (int index2 = 0; index2 < 14; index2++) {
							if (world.getBlockState(BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1), Direction.NORTH)
									&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1))) {
								is_valid = true;
								break;
							}
							nb = nb + 1;
						}
					} else if (world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + 1, rdmZ), Direction.EAST)
							&& world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + 2, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + 2, rdmZ), Direction.EAST)
							&& world.getBlockState(BlockPos.containing(rdmX + 1, rdmY, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY, rdmZ), Direction.EAST)) {
						nb = 3;
						for (int index3 = 0; index3 < 14; index3++) {
							if (world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ), Direction.EAST)
									&& world.isEmptyBlock(BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ))) {
								is_valid = true;
								break;
							}
							nb = nb + 1;
						}
					} else if (world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + 1, rdmZ), Direction.WEST)
							&& world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + 2, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + 2, rdmZ), Direction.WEST)
							&& world.getBlockState(BlockPos.containing(rdmX - 1, rdmY, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY, rdmZ), Direction.WEST)) {
						nb = 3;
						for (int index4 = 0; index4 < 14; index4++) {
							if (world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ), Direction.WEST)
									&& world.isEmptyBlock(BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ))) {
								is_valid = true;
								break;
							}
							nb = nb + 1;
						}
					}
				}
				if (is_valid) {
					if (entity instanceof SquirrelEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SquirrelEntity.DATA_x_target, (int) rdmX);
					if (entity instanceof SquirrelEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SquirrelEntity.DATA_y_target, (int) rdmY);
					if (entity instanceof SquirrelEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SquirrelEntity.DATA_z_target, (int) rdmZ);
					break;
				}
			}
			if (is_valid) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0),
							(entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_y_target) : 0), (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0),
							1);
				world.setBlock(
						BlockPos.containing(entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0,
								entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_y_target) : 0, entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0),
						Blocks.EMERALD_BLOCK.defaultBlockState(), 3);
			} else {
				if (entity instanceof SquirrelEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SquirrelEntity.DATA_is_climbing, false);
			}
		} else {
			if (entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0) {
				if ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_climb_cooldown) : 0) >= 60) {
					if (entity instanceof SquirrelEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SquirrelEntity.DATA_climb_cooldown, 0);
					if (entity instanceof SquirrelEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SquirrelEntity.DATA_is_climbing, true);
				} else {
					if (entity instanceof SquirrelEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SquirrelEntity.DATA_climb_cooldown, (int) ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_climb_cooldown) : 0) + 1));
				}
			} else {
				if (entity instanceof SquirrelEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SquirrelEntity.DATA_climb_cooldown, 0);
			}
		}
	}
}
