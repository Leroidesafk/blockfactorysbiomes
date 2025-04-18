package net.unusual.blockfactorysbiomes.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MapleSaplingOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Math.random() < 0.1 && !(world.isClientSide())) {
			sx = -1;
			found = true;
			for (int index0 = 0; index0 < 3; index0++) {
				sy = 0;
				for (int index1 = 0; index1 < 5; index1++) {
					sz = -1;
					for (int index2 = 0; index2 < 3; index2++) {
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
				sx = -4;
				for (int index3 = 0; index3 < 9; index3++) {
					sy = 6;
					for (int index4 = 0; index4 < 11; index4++) {
						sz = -4;
						for (int index5 = 0; index5 < 9; index5++) {
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
				if (Math.random() < 0.2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "maple_tree1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "maple_tree2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (Math.random() < 0.33) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "maple_tree3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "maple_tree4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "maple_tree5"));
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
