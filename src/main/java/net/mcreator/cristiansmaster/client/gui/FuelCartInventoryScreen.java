package net.mcreator.cristiansmaster.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.cristiansmaster.world.inventory.FuelCartInventoryMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FuelCartInventoryScreen extends AbstractContainerScreen<FuelCartInventoryMenu> {
	private final static HashMap<String, Object> guistate = FuelCartInventoryMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public FuelCartInventoryScreen(FuelCartInventoryMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("cristian_s_master:textures/screens/fuel_cart_inventory.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.cristian_s_master.fuel_cart_inventory.label_fuel_cart"), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cristian_s_master.fuel_cart_inventory.label_inventory"), 6, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
