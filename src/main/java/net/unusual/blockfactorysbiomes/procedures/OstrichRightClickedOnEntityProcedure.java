package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.entity.OstrichEntity;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

public class OstrichRightClickedOnEntityProcedure {
	public static boolean execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		if ((entity instanceof OstrichEntity _datEntI ? _datEntI.getEntityData().get(OstrichEntity.DATA_hide_animtime) : 0) == 0 && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.isBaby())) {
			if (entity instanceof OstrichEntity _datEntL2 && _datEntL2.getEntityData().get(OstrichEntity.DATA_has_saddle)) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem() && sourceentity.isShiftKeyDown()) {
					if (entity instanceof OstrichEntity _datEntSetL)
						_datEntSetL.getEntityData().set(OstrichEntity.DATA_has_saddle, false);
					if (sourceentity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.SADDLE).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					return true;
				} else if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WHEAT_SEEDS
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PUMPKIN_SEEDS
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MELON_SEEDS
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BEETROOT_SEEDS) && !entity.isVehicle()) {
					sourceentity.startRiding(entity);
					return true;
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SADDLE) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				if (entity instanceof OstrichEntity _datEntSetL)
					_datEntSetL.getEntityData().set(OstrichEntity.DATA_has_saddle, true);
				return true;
			}
		}
		return false;
	}
}
