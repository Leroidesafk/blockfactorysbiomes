
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class CookedDeerBeefItem extends Item {
	public CookedDeerBeefItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).meat().build()));
	}
}