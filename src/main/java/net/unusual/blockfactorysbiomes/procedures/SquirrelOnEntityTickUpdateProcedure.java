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
		double distance = 0;
		if (entity instanceof SquirrelEntity _datEntL0 && _datEntL0.getEntityData().get(SquirrelEntity.DATA_is_climbing)) {
			if ((entity instanceof SquirrelEntity _datEntS ? _datEntS.getEntityData().get(SquirrelEntity.DATA_climb_direction) : "").equals("" + Direction.NORTH)) {
				{
					Entity _ent = entity;
					_ent.setYRot(180);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				rdmX = (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0) + 0.5;
				rdmZ = entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0;
			} else if ((entity instanceof SquirrelEntity _datEntS ? _datEntS.getEntityData().get(SquirrelEntity.DATA_climb_direction) : "").equals("" + Direction.SOUTH)) {
				{
					Entity _ent = entity;
					_ent.setYRot(0);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				rdmX = (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0) + 0.5;
				rdmZ = (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0) + 1;
			} else if ((entity instanceof SquirrelEntity _datEntS ? _datEntS.getEntityData().get(SquirrelEntity.DATA_climb_direction) : "").equals("" + Direction.EAST)) {
				{
					Entity _ent = entity;
					_ent.setYRot(-90);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				rdmX = (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0) + 1;
				rdmZ = (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0) + 0.5;
			} else if ((entity instanceof SquirrelEntity _datEntS ? _datEntS.getEntityData().get(SquirrelEntity.DATA_climb_direction) : "").equals("" + Direction.WEST)) {
				{
					Entity _ent = entity;
					_ent.setYRot(90);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				rdmX = entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0;
				rdmZ = (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0) + 0.5;
			}
			if (world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) + (entity.getDirection()).getStepX(), Math.floor(entity.getY()), Math.floor(entity.getZ()) + (entity.getDirection()).getStepZ())).isFaceSturdy(world,
					BlockPos.containing(Math.floor(entity.getX()) + (entity.getDirection()).getStepX(), Math.floor(entity.getY()), Math.floor(entity.getZ()) + (entity.getDirection()).getStepZ()), ((entity.getDirection()).getOpposite()))
					&& !world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), Math.floor(entity.getY()) + 1, Math.floor(entity.getZ()))).isFaceSturdy(world,
							BlockPos.containing(Math.floor(entity.getX()), Math.floor(entity.getY()) + 1, Math.floor(entity.getZ())), Direction.DOWN)) {
				distance = Math.abs(entity.getX() - rdmX) + Math.abs(entity.getZ() - rdmZ);
				entity.setDeltaMovement(new Vec3((((entity.getX() - rdmX) / (distance == 0 ? 0.001 : distance)) * (-0.1)), (entity.getDeltaMovement().y() > 0.2 ? entity.getDeltaMovement().y() : entity.getDeltaMovement().y() + 0.15),
						(((entity.getZ() - rdmZ) / (distance == 0 ? 0.001 : distance)) * (-0.1))));
			} else {
				if (entity instanceof SquirrelEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SquirrelEntity.DATA_is_climbing, false);
				if (entity instanceof SquirrelEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SquirrelEntity.DATA_x_target, (int) Math.floor(entity.getX()));
				if (entity instanceof SquirrelEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SquirrelEntity.DATA_y_target, (int) Math.floor(entity.getY()));
				if (entity instanceof SquirrelEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SquirrelEntity.DATA_z_target, (int) Math.floor(entity.getZ()));
			}
		} else if (entity instanceof SquirrelEntity _datEntL50 && _datEntL50.getEntityData().get(SquirrelEntity.DATA_can_start_climbing)) {
			is_valid = false;
			rdmX = entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0;
			rdmY = entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_y_target) : 0;
			rdmZ = entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0;
			if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY, rdmZ)) && world.getBlockState(BlockPos.containing(rdmX, rdmY - 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY - 1, rdmZ), Direction.UP)) {
				if (world.getBlockState(BlockPos.containing(rdmX, rdmY + 1, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 1, rdmZ - 1), Direction.SOUTH)
						&& world.getBlockState(BlockPos.containing(rdmX, rdmY + 2, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 2, rdmZ - 1), Direction.SOUTH)
						&& world.getBlockState(BlockPos.containing(rdmX, rdmY, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY, rdmZ - 1), Direction.SOUTH)) {
					nb = 3;
					for (int index0 = 0; index0 < 14; index0++) {
						if (world.getBlockState(BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1), Direction.SOUTH)
								&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
							if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ - 1))) {
								if (entity instanceof SquirrelEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.NORTH));
								is_valid = true;
								break;
							}
						} else {
							break;
						}
						nb = nb + 1;
					}
				} else if (world.getBlockState(BlockPos.containing(rdmX, rdmY + 1, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 1, rdmZ + 1), Direction.NORTH)
						&& world.getBlockState(BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1), Direction.NORTH)
						&& world.getBlockState(BlockPos.containing(rdmX, rdmY, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY, rdmZ + 1), Direction.NORTH)) {
					nb = 3;
					for (int index1 = 0; index1 < 14; index1++) {
						if (world.getBlockState(BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1), Direction.NORTH)
								&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
							if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ + 1))) {
								if (entity instanceof SquirrelEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.SOUTH));
								is_valid = true;
								break;
							}
						} else {
							break;
						}
						nb = nb + 1;
					}
				} else if (world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + 1, rdmZ), Direction.WEST)
						&& world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + 2, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + 2, rdmZ), Direction.WEST)
						&& world.getBlockState(BlockPos.containing(rdmX + 1, rdmY, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY, rdmZ), Direction.WEST)) {
					nb = 3;
					for (int index2 = 0; index2 < 14; index2++) {
						if (world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ), Direction.WEST)
								&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
							if (world.isEmptyBlock(BlockPos.containing(rdmX + 1, rdmY + nb + 1, rdmZ))) {
								if (entity instanceof SquirrelEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.EAST));
								is_valid = true;
								break;
							}
						} else {
							break;
						}
						nb = nb + 1;
					}
				} else if (world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + 1, rdmZ), Direction.EAST)
						&& world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + 2, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + 2, rdmZ), Direction.EAST)
						&& world.getBlockState(BlockPos.containing(rdmX - 1, rdmY, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY, rdmZ), Direction.DOWN)) {
					nb = 3;
					for (int index3 = 0; index3 < 14; index3++) {
						if (world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ), Direction.EAST)
								&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
							if (world.isEmptyBlock(BlockPos.containing(rdmX - 1, rdmY + nb + 1, rdmZ))) {
								if (entity instanceof SquirrelEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.WEST));
								is_valid = true;
								break;
							}
						} else {
							break;
						}
						nb = nb + 1;
					}
				}
			}
			if (!is_valid) {
				for (int index4 = 0; index4 < 500; index4++) {
					rdmX = Math.floor(entity.getX()) + Mth.nextInt(RandomSource.create(), -10, 10);
					rdmY = Math.floor(entity.getY()) + Mth.nextInt(RandomSource.create(), -2, 2);
					rdmZ = Math.floor(entity.getZ()) + Mth.nextInt(RandomSource.create(), -10, 10);
					if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY, rdmZ)) && world.getBlockState(BlockPos.containing(rdmX, rdmY - 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY - 1, rdmZ), Direction.UP)) {
						if (world.getBlockState(BlockPos.containing(rdmX, rdmY + 1, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 1, rdmZ - 1), Direction.SOUTH)
								&& world.getBlockState(BlockPos.containing(rdmX, rdmY + 2, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 2, rdmZ - 1), Direction.SOUTH)
								&& world.getBlockState(BlockPos.containing(rdmX, rdmY, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY, rdmZ - 1), Direction.SOUTH)) {
							nb = 3;
							for (int index5 = 0; index5 < 14; index5++) {
								if (world.getBlockState(BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + nb, rdmZ - 1), Direction.SOUTH)
										&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
									if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ - 1))) {
										if (entity instanceof SquirrelEntity _datEntSetS)
											_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.NORTH));
										is_valid = true;
										break;
									}
								} else {
									break;
								}
								nb = nb + 1;
							}
						} else if (world.getBlockState(BlockPos.containing(rdmX, rdmY + 1, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 1, rdmZ + 1), Direction.NORTH)
								&& world.getBlockState(BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + 2, rdmZ + 1), Direction.NORTH)
								&& world.getBlockState(BlockPos.containing(rdmX, rdmY, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY, rdmZ + 1), Direction.NORTH)) {
							nb = 3;
							for (int index6 = 0; index6 < 14; index6++) {
								if (world.getBlockState(BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1)).isFaceSturdy(world, BlockPos.containing(rdmX, rdmY + nb, rdmZ + 1), Direction.NORTH)
										&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
									if (world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ + 1))) {
										if (entity instanceof SquirrelEntity _datEntSetS)
											_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.SOUTH));
										is_valid = true;
										break;
									}
								} else {
									break;
								}
								nb = nb + 1;
							}
						} else if (world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + 1, rdmZ), Direction.WEST)
								&& world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + 2, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + 2, rdmZ), Direction.WEST)
								&& world.getBlockState(BlockPos.containing(rdmX + 1, rdmY, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY, rdmZ), Direction.WEST)) {
							nb = 3;
							for (int index7 = 0; index7 < 14; index7++) {
								if (world.getBlockState(BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX + 1, rdmY + nb, rdmZ), Direction.WEST)
										&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
									if (world.isEmptyBlock(BlockPos.containing(rdmX + 1, rdmY + nb + 1, rdmZ))) {
										if (entity instanceof SquirrelEntity _datEntSetS)
											_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.EAST));
										is_valid = true;
										break;
									}
								} else {
									break;
								}
								nb = nb + 1;
							}
						} else if (world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + 1, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + 1, rdmZ), Direction.EAST)
								&& world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + 2, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + 2, rdmZ), Direction.EAST)
								&& world.getBlockState(BlockPos.containing(rdmX - 1, rdmY, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY, rdmZ), Direction.DOWN)) {
							nb = 3;
							for (int index8 = 0; index8 < 14; index8++) {
								if (world.getBlockState(BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ)).isFaceSturdy(world, BlockPos.containing(rdmX - 1, rdmY + nb, rdmZ), Direction.EAST)
										&& world.isEmptyBlock(BlockPos.containing(rdmX, rdmY + nb + 1, rdmZ))) {
									if (world.isEmptyBlock(BlockPos.containing(rdmX - 1, rdmY + nb + 1, rdmZ))) {
										if (entity instanceof SquirrelEntity _datEntSetS)
											_datEntSetS.getEntityData().set(SquirrelEntity.DATA_climb_direction, ("" + Direction.WEST));
										is_valid = true;
										break;
									}
								} else {
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
			}
			if (is_valid) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0),
							(entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_y_target) : 0), (entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0),
							1);
				distance = Math.abs(entity.getX() - ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0) + 0.5))
						+ Math.abs(entity.getY() - ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_y_target) : 0) + 0.5))
						+ Math.abs(entity.getZ() - ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0) + 0.5));
				if (distance < 0.1) {
					if (entity instanceof SquirrelEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SquirrelEntity.DATA_is_climbing, true);
					if (entity instanceof SquirrelEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SquirrelEntity.DATA_can_start_climbing, false);
				} else if (distance < 2) {
					entity.setDeltaMovement(new Vec3(
							(entity.getDeltaMovement().x() + ((entity.getX() - ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_x_target) : 0) + 0.5)) / (distance == 0 ? 0.001 : distance)) * (-0.1)),
							(entity.getDeltaMovement().y() + ((entity.getY() - ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_y_target) : 0) + 0.5)) / (distance == 0 ? 0.001 : distance)) * (-0.1)),
							(entity.getDeltaMovement().z() + ((entity.getZ() - ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_z_target) : 0) + 0.5)) / (distance == 0 ? 0.001 : distance)) * (-0.1))));
				}
			} else {
				if (entity instanceof SquirrelEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SquirrelEntity.DATA_can_start_climbing, false);
			}
		} else {
			if (entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0) {
				if ((entity instanceof SquirrelEntity _datEntI ? _datEntI.getEntityData().get(SquirrelEntity.DATA_climb_cooldown) : 0) >= 60) {
					if (entity instanceof SquirrelEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SquirrelEntity.DATA_climb_cooldown, 0);
					if (entity instanceof SquirrelEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SquirrelEntity.DATA_can_start_climbing, true);
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
