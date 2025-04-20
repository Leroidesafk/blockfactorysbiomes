
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class CopperHoeItem extends HoeItem {
	public CopperHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 131;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 11;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.COPPER_INGOT));
			}
		}, 0, 0f, new Item.Properties());
	}
}
