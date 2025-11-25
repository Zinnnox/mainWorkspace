package net.mcreator.cristiansmaster.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import net.mcreator.cristiansmaster.init.CristianSMasterModItems;
import net.mcreator.cristiansmaster.client.gui.DiamondBackpackGUIScreen;

import javax.annotation.Nonnull;

@EventBusSubscriber(Dist.CLIENT)
public class DiamondBackpackInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == CristianSMasterModItems.DIAMOND_BACKPACK.get()) {
			if (Minecraft.getInstance().screen instanceof DiamondBackpackGUIScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public DiamondBackpackInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 36);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 128;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != CristianSMasterModItems.DIAMOND_BACKPACK.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}
