
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.world.inventory.TeleporterButtonGuiMenu;
import net.mcreator.cristiansmaster.world.inventory.GoooMenu;
import net.mcreator.cristiansmaster.world.inventory.BackpackGuiMenu;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, CristianSMasterMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<GoooMenu>> GUIFORREPLICATRO = REGISTRY.register("guiforreplicatro", () -> IMenuTypeExtension.create(GoooMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackGuiMenu>> BACKPACK_GUI = REGISTRY.register("backpack_gui", () -> IMenuTypeExtension.create(BackpackGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TeleporterButtonGuiMenu>> TELEPORTER_BUTTON_GUI = REGISTRY.register("teleporter_button_gui", () -> IMenuTypeExtension.create(TeleporterButtonGuiMenu::new));
}
