
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.cristiansmaster.network.SpawnSILLYGOOSEMessage;
import net.mcreator.cristiansmaster.network.ShootIceshardMessage;
import net.mcreator.cristiansmaster.network.ShootFireballMessage;
import net.mcreator.cristiansmaster.network.OpenGuiBuildersWandMessage;
import net.mcreator.cristiansmaster.network.OpenAttributeChangerMessage;
import net.mcreator.cristiansmaster.network.KeyPressedSpaceMessage;
import net.mcreator.cristiansmaster.network.IroncladspawnedMessage;
import net.mcreator.cristiansmaster.network.FillWithBuildersWandMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CristianSMasterModKeyMappings {
	public static final KeyMapping KEY_PRESSED_SPACE = new KeyMapping("key.cristian_s_master.key_pressed_space", GLFW.GLFW_KEY_SPACE, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new KeyPressedSpaceMessage(0, 0));
				KeyPressedSpaceMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				KEY_PRESSED_SPACE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - KEY_PRESSED_SPACE_LASTPRESS);
				PacketDistributor.sendToServer(new KeyPressedSpaceMessage(1, dt));
				KeyPressedSpaceMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHOOT_FIREBALL = new KeyMapping("key.cristian_s_master.shoot_fireball", GLFW.GLFW_KEY_K, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ShootFireballMessage(0, 0));
				ShootFireballMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHOOT_ICESHARD = new KeyMapping("key.cristian_s_master.shoot_iceshard", GLFW.GLFW_KEY_J, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ShootIceshardMessage(0, 0));
				ShootIceshardMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping IRONCLADSPAWNED = new KeyMapping("key.cristian_s_master.ironcladspawned", GLFW.GLFW_KEY_M, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new IroncladspawnedMessage(0, 0));
				IroncladspawnedMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SPAWN_SILLYGOOSE = new KeyMapping("key.cristian_s_master.spawn_sillygoose", GLFW.GLFW_KEY_N, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new SpawnSILLYGOOSEMessage(0, 0));
				SpawnSILLYGOOSEMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_BACKPACK = new KeyMapping("key.cristian_s_master.open_backpack", GLFW.GLFW_KEY_L, "key.categories.misc");
	public static final KeyMapping OPEN_GUI_BUILDERS_WAND = new KeyMapping("key.cristian_s_master.open_gui_builders_wand", GLFW.GLFW_KEY_K, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenGuiBuildersWandMessage(0, 0));
				OpenGuiBuildersWandMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FILL_WITH_BUILDERS_WAND = new KeyMapping("key.cristian_s_master.fill_with_builders_wand", GLFW.GLFW_KEY_C, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new FillWithBuildersWandMessage(0, 0));
				FillWithBuildersWandMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				FILL_WITH_BUILDERS_WAND_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FILL_WITH_BUILDERS_WAND_LASTPRESS);
				PacketDistributor.sendToServer(new FillWithBuildersWandMessage(1, dt));
				FillWithBuildersWandMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_ATTRIBUTE_CHANGER = new KeyMapping("key.cristian_s_master.open_attribute_changer", GLFW.GLFW_KEY_PERIOD, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenAttributeChangerMessage(0, 0));
				OpenAttributeChangerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long KEY_PRESSED_SPACE_LASTPRESS = 0;
	private static long FILL_WITH_BUILDERS_WAND_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(KEY_PRESSED_SPACE);
		event.register(SHOOT_FIREBALL);
		event.register(SHOOT_ICESHARD);
		event.register(IRONCLADSPAWNED);
		event.register(SPAWN_SILLYGOOSE);
		event.register(OPEN_BACKPACK);
		event.register(OPEN_GUI_BUILDERS_WAND);
		event.register(FILL_WITH_BUILDERS_WAND);
		event.register(OPEN_ATTRIBUTE_CHANGER);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				KEY_PRESSED_SPACE.consumeClick();
				SHOOT_FIREBALL.consumeClick();
				SHOOT_ICESHARD.consumeClick();
				IRONCLADSPAWNED.consumeClick();
				SPAWN_SILLYGOOSE.consumeClick();
				OPEN_GUI_BUILDERS_WAND.consumeClick();
				FILL_WITH_BUILDERS_WAND.consumeClick();
				OPEN_ATTRIBUTE_CHANGER.consumeClick();
			}
		}
	}
}
