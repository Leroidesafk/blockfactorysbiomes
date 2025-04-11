
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class RawCrabMeatItem extends Item {
	public RawCrabMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.1f).meat().build()));
	}
}
