package net.mcreator.cristiansmaster.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.cristiansmaster.world.inventory.TeleporterButtonGuiMenu;
import net.mcreator.cristiansmaster.network.TeleporterButtonGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TeleporterButtonGuiScreen extends AbstractContainerScreen<TeleporterButtonGuiMenu> {
	private final static HashMap<String, Object> guistate = TeleporterButtonGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_save_current_position;
	Button button_teleport_to_saved_position;

	public TeleporterButtonGuiScreen(TeleporterButtonGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 175;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("cristian_s_master:textures/screens/teleporter_button_gui.png");

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
	}

	@Override
	public void init() {
		super.init();
		button_save_current_position = Button.builder(Component.translatable("gui.cristian_s_master.teleporter_button_gui.button_save_current_position"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new TeleporterButtonGuiButtonMessage(0, x, y, z));
				TeleporterButtonGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 24, this.topPos + 28, 134, 20).build();
		guistate.put("button:button_save_current_position", button_save_current_position);
		this.addRenderableWidget(button_save_current_position);
		button_teleport_to_saved_position = Button.builder(Component.translatable("gui.cristian_s_master.teleporter_button_gui.button_teleport_to_saved_position"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new TeleporterButtonGuiButtonMessage(1, x, y, z));
				TeleporterButtonGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 64, 160, 20).build();
		guistate.put("button:button_teleport_to_saved_position", button_teleport_to_saved_position);
		this.addRenderableWidget(button_teleport_to_saved_position);
	}
}
