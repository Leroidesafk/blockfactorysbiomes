
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OstrichEggItem extends Item {
	public OstrichEggItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
