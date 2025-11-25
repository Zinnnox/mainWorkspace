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

import net.mcreator.cristiansmaster.world.inventory.AttributeChangerMenu;
import net.mcreator.cristiansmaster.network.AttributeChangerButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AttributeChangerScreen extends AbstractContainerScreen<AttributeChangerMenu> {
	private final static HashMap<String, Object> guistate = AttributeChangerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_1_jump;
	Button button_1_jump1;
	Button button_1_speed;
	Button button_1_speed1;
	Button button_reset_all;

	public AttributeChangerScreen(AttributeChangerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("cristian_s_master:textures/screens/attribute_changer.png");

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
		button_1_jump = Button.builder(Component.translatable("gui.cristian_s_master.attribute_changer.button_1_jump"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AttributeChangerButtonMessage(0, x, y, z));
				AttributeChangerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 7, 61, 20).build();
		guistate.put("button:button_1_jump", button_1_jump);
		this.addRenderableWidget(button_1_jump);
		button_1_jump1 = Button.builder(Component.translatable("gui.cristian_s_master.attribute_changer.button_1_jump1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AttributeChangerButtonMessage(1, x, y, z));
				AttributeChangerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 7, 61, 20).build();
		guistate.put("button:button_1_jump1", button_1_jump1);
		this.addRenderableWidget(button_1_jump1);
		button_1_speed = Button.builder(Component.translatable("gui.cristian_s_master.attribute_changer.button_1_speed"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AttributeChangerButtonMessage(2, x, y, z));
				AttributeChangerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 34, 66, 20).build();
		guistate.put("button:button_1_speed", button_1_speed);
		this.addRenderableWidget(button_1_speed);
		button_1_speed1 = Button.builder(Component.translatable("gui.cristian_s_master.attribute_changer.button_1_speed1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AttributeChangerButtonMessage(3, x, y, z));
				AttributeChangerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 34, 66, 20).build();
		guistate.put("button:button_1_speed1", button_1_speed1);
		this.addRenderableWidget(button_1_speed1);
		button_reset_all = Button.builder(Component.translatable("gui.cristian_s_master.attribute_changer.button_reset_all"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AttributeChangerButtonMessage(4, x, y, z));
				AttributeChangerButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 51, this.topPos + 133, 72, 20).build();
		guistate.put("button:button_reset_all", button_reset_all);
		this.addRenderableWidget(button_reset_all);
	}
}
