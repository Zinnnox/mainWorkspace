package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.init.CristianSMasterModItems;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class PhoenixFeatherItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).hasPhoenixFeatherBeenUsed == 1) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CristianSMasterModItems.PHOENIX_FEATHER.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(CristianSMasterModItems.BURNT_PHEONIX_FEATHTER.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			CristianSMasterMod.queueServerWork(100, () -> {
				CristianSMasterModVariables.MapVariables.get(world).hasPhoenixFeatherBeenUsed = 0;
				CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
