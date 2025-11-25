package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.init.CristianSMasterModItems;

public class OreLocatorRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(CristianSMasterModItems.REDSTONE_BATTERY.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CristianSMasterModItems.REDSTONE_BATTERY.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			sx = -6;
			found = false;
			for (int index0 = 0; index0 < (int) (sx * (-2)); index0++) {
				sy = -6;
				for (int index1 = 0; index1 < (int) (sy * (-2)); index1++) {
					sz = -6;
					for (int index2 = 0; index2 < (int) (sz * (-2)); index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.DIAMOND_ORE) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found == true) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Ore detected nearby!"), false);
			} else {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("No ore detected nearby"), false);
			}
		} else {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("The Ore Locator has no power!"), false);
		}
	}
}
