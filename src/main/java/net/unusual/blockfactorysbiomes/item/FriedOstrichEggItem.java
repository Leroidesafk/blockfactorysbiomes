
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FriedOstrichEggItem extends Item {
	public FriedOstrichEggItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5f).meat().build()));
	}
}
