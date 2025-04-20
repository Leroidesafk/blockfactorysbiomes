package net.unusual.blockfactorysbiomes;

import net.unusual.blockfactorysbiomes.init.BfBiomesModItems;
import net.unusual.blockfactorysbiomes.init.BfBiomesModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class AttributeModifiers {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		AttributeModifier modifier = null;
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
			if (itemstack.getItem() == BfBiomesModItems.COPPER_HELMET.get()) {
				modifier = new AttributeModifier(UUID.fromString("39bb2d7a-86ec-421d-9bd9-7d5647b1e648"), BfBiomesMod.MODID + "." + "lightningChance", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL);
				_event.addModifier(BfBiomesModAttributes.LIGHTNINGSTRUCKCHANCE.get(), modifier);
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
			if (itemstack.getItem() == BfBiomesModItems.COPPER_CHESTPLATE.get()) {
				modifier = new AttributeModifier(UUID.fromString("39bb2d7a-86ec-421d-9bd9-7d5647b1e648"), BfBiomesMod.MODID + "." + "lightningChance", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL);
				_event.addModifier(BfBiomesModAttributes.LIGHTNINGSTRUCKCHANCE.get(), modifier);
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
			if (itemstack.getItem() == BfBiomesModItems.COPPER_LEGGINGS.get()) {
				modifier = new AttributeModifier(UUID.fromString("39bb2d7a-86ec-421d-9bd9-7d5647b1e648"), BfBiomesMod.MODID + "." + "lightningChance", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL);
				_event.addModifier(BfBiomesModAttributes.LIGHTNINGSTRUCKCHANCE.get(), modifier);
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
			if (itemstack.getItem() == BfBiomesModItems.COPPER_BOOTS.get()) {
				modifier = new AttributeModifier(UUID.fromString("39bb2d7a-86ec-421d-9bd9-7d5647b1e648"), BfBiomesMod.MODID + "." + "lightningChance", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL);
				_event.addModifier(BfBiomesModAttributes.LIGHTNINGSTRUCKCHANCE.get(), modifier);
			}
		}
	}
}
