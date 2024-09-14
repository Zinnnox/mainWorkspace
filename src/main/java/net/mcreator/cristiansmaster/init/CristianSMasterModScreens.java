
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.cristiansmaster.client.gui.GoooScreen;
import net.mcreator.cristiansmaster.client.gui.BackpackGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CristianSMasterModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(CristianSMasterModMenus.GUIFORREPLICATRO.get(), GoooScreen::new);
		event.register(CristianSMasterModMenus.BACKPACK_GUI.get(), BackpackGuiScreen::new);
	}
}
