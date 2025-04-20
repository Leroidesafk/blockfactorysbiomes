
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class RawDeerBeefItem extends Item {
	public RawDeerBeefItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).meat().build()));
	}
}