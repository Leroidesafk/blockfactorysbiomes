
package net.unusual.blockfactorysbiomes.world.features;

public class MapleTreeFeature extends SimpleRandomSelectorFeature {
	public MapleTreeFeature() {
		super(SimpleRandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!MapleTreeAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}