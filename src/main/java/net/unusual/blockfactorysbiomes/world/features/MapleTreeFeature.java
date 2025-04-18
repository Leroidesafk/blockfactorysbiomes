
package net.unusual.blockfactorysbiomes.world.features;

import net.unusual.blockfactorysbiomes.procedures.MapleTreeAdditionalGenerationConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class MapleTreeFeature extends SimpleRandomSelectorFeature {
	public MapleTreeFeature() {
		super(SimpleRandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!MapleTreeAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
