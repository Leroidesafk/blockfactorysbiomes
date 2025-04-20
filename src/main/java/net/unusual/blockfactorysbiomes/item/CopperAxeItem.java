
package net.unusual.blockfactorysbiomes.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class CopperAxeItem extends AxeItem {
	public CopperAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 131;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 11;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.COPPER_INGOT));
			}
		}, 1, -3.1f, new Item.Properties());
	}
}
