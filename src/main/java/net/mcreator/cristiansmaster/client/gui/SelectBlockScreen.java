package net.mcreator.cristiansmaster.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.cristiansmaster.world.inventory.SelectBlockMenu;
import net.mcreator.cristiansmaster.network.SelectBlockButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SelectBlockScreen extends AbstractContainerScreen<SelectBlockMenu> {
	private final static HashMap<String, Object> guistate = SelectBlockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox input;
	Button button_diamond_block;

	public SelectBlockScreen(SelectBlockMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("cristian_s_master:textures/screens/select_block.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		input.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (input.isFocused())
			return input.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String inputValue = input.getValue();
		super.resize(minecraft, width, height);
		input.setValue(inputValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.cristian_s_master.select_block.label_select_a_block"), 51, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		input = new EditBox(this.font, this.leftPos + 25, this.topPos + 53, 118, 18, Component.translatable("gui.cristian_s_master.select_block.input")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.cristian_s_master.select_block.input").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.cristian_s_master.select_block.input").getString());
				else
					setSuggestion(null);
			}
		};
		input.setMaxLength(32767);
		input.setSuggestion(Component.translatable("gui.cristian_s_master.select_block.input").getString());
		guistate.put("text:input", input);
		this.addWidget(this.input);
		button_diamond_block = Button.builder(Component.translatable("gui.cristian_s_master.select_block.button_diamond_block"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SelectBlockButtonMessage(0, x, y, z));
				SelectBlockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 97, 93, 20).build();
		guistate.put("button:button_diamond_block", button_diamond_block);
		this.addRenderableWidget(button_diamond_block);
	}
}
