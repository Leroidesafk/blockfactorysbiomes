package net.unusual.blockfactorysbiomes.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BaobabSaplingOnBoneMealSuccesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "baobab_tree1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (Math.random() < 0.25) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "baobab_tree2"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (Math.random() < 0.33) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "baobab_tree3"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (Math.random() < 0.5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "baobab_tree4"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("bf_biomes", "baobab_tree5"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 6), BlockPos.containing(x - 6, y, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
