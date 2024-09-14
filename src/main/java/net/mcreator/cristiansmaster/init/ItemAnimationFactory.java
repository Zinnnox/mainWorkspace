package net.mcreator.cristiansmaster.init;

import software.bernie.geckolib.animatable.GeoItem;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.cristiansmaster.item.GrimoireItem;

@EventBusSubscriber
public class ItemAnimationFactory {
	public static void disableUseAnim(String hand) {
		ItemInHandRenderer renderer = Minecraft.getInstance().gameRenderer.itemInHandRenderer;
		if (renderer != null) {
			if (hand.equals("right")) {
				renderer.mainHandHeight = 1F;
				renderer.oMainHandHeight = 1F;
			}
			if (hand.equals("left")) {
				renderer.offHandHeight = 1F;
				renderer.oOffHandHeight = 1F;
			}
		}
	}

	@SubscribeEvent
	public static void animatedItems(PlayerTickEvent.Post event) {
		String animation = "";
		ItemStack mainhandItem = event.getEntity().getMainHandItem().copy();
		ItemStack offhandItem = event.getEntity().getOffhandItem().copy();
		if (mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem) {
			if (mainhandItem.getItem() instanceof GrimoireItem animatable) {
				animation = mainhandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("geckoAnim");
				if (!animation.isEmpty()) {
					CustomData.update(DataComponents.CUSTOM_DATA, event.getEntity().getMainHandItem(), tag -> tag.putString("geckoAnim", ""));
					if (event.getEntity().level().isClientSide()) {
						((GrimoireItem) event.getEntity().getMainHandItem().getItem()).animationprocedure = animation;
					}
				}
			}
			if (offhandItem.getItem() instanceof GrimoireItem animatable) {
				animation = offhandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("geckoAnim");
				if (!animation.isEmpty()) {
					CustomData.update(DataComponents.CUSTOM_DATA, event.getEntity().getOffhandItem(), tag -> tag.putString("geckoAnim", ""));
					if (event.getEntity().level().isClientSide()) {
						((GrimoireItem) event.getEntity().getOffhandItem().getItem()).animationprocedure = animation;
					}
				}
			}
		}
	}
}
