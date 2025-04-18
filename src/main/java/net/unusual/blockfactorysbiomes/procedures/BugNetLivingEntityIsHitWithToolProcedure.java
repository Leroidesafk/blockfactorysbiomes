package net.unusual.blockfactorysbiomes.procedures;

import net.unusual.blockfactorysbiomes.init.BfBiomesModItems;
import net.unusual.blockfactorysbiomes.entity.FireflyEntity;
import net.unusual.blockfactorysbiomes.entity.ButterflyEntity;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class BugNetLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof FireflyEntity) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(BfBiomesModItems.FIRE_FLY_ITEM.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (entity instanceof ButterflyEntity) {
			if ((entity instanceof ButterflyEntity _datEntI ? _datEntI.getEntityData().get(ButterflyEntity.DATA_color) : 0) == 0) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(BfBiomesModItems.ORANGE_BUTTERFLY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if ((entity instanceof ButterflyEntity _datEntI ? _datEntI.getEntityData().get(ButterflyEntity.DATA_color) : 0) == 1) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(BfBiomesModItems.BLUE_BUTTERFLY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if ((entity instanceof ButterflyEntity _datEntI ? _datEntI.getEntityData().get(ButterflyEntity.DATA_color) : 0) == 2) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(BfBiomesModItems.GREEN_BUTTERFLY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if ((entity instanceof ButterflyEntity _datEntI ? _datEntI.getEntityData().get(ButterflyEntity.DATA_color) : 0) == 3) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(BfBiomesModItems.PINK_BUTTERFLY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}
