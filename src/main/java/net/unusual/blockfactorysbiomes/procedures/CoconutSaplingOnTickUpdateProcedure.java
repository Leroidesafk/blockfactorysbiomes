package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

public class CoconutSaplingOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Math.random() < 0.1 && !(world.isClientSide())) {
			sx = -1;
			found = true;
			for (int index0 = 0; index0 < 4; index0++) {
				sy = 0;
				for (int index1 = 0; index1 < 6; index1++) {
					sz = -1;
					for (int index2 = 0; index2 < 4; index2++) {
						if (!world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
							if (x != x + sx && y != y + sy && z != z + sz) {
								found = false;
								break;
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
					if (!found) {
						break;
					}
				}
				sx = sx + 1;
				if (!found) {
					break;
				}
			}
			if (found) {
				sx = -6;
				for (int index3 = 0; index3 < 13; index3++) {
					sy = 8;
					for (int index4 = 0; index4 < 11; index4++) {
						sz = -6;
						for (int index5 = 0; index5 < 13; index5++) {
							if (!world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
								found = false;
								break;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
						if (!found) {
							break;
						}
					}
					sx = sx + 1;
					if (!found) {
						break;
					}
				}
			}
			if (found) {
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "coconut_tree1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (Math.random() < 0.33) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "coconut_tree2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "coconut_tree3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "coconut_tree4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		}
	}
}
