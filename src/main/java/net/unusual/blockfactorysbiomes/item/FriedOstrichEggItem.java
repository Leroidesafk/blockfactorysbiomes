
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class FriedOstrichEggItem extends Item {
	public FriedOstrichEggItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5f).meat().build()));
	}
}