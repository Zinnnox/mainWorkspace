
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
import net.mcreator.cristiansmaster.world.inventory.SimpleBackpackGUIMenu;
import net.mcreator.cristiansmaster.world.inventory.SelectBlockMenu;
import net.mcreator.cristiansmaster.world.inventory.FuelCartInventoryMenu;
import net.mcreator.cristiansmaster.world.inventory.DrillCartInventoryMenu;
import net.mcreator.cristiansmaster.world.inventory.DiamondBackpackGUIMenu;
import net.mcreator.cristiansmaster.world.inventory.CargoCatInventoryMenu;
import net.mcreator.cristiansmaster.world.inventory.BackpackGuiMenu;
import net.mcreator.cristiansmaster.world.inventory.AttributeChangerMenu;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, CristianSMasterMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackGuiMenu>> BACKPACK_GUI = REGISTRY.register("backpack_gui", () -> IMenuTypeExtension.create(BackpackGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TeleporterButtonGuiMenu>> TELEPORTER_BUTTON_GUI = REGISTRY.register("teleporter_button_gui", () -> IMenuTypeExtension.create(TeleporterButtonGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SelectBlockMenu>> SELECT_BLOCK = REGISTRY.register("select_block", () -> IMenuTypeExtension.create(SelectBlockMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FuelCartInventoryMenu>> FUEL_CART_INVENTORY = REGISTRY.register("fuel_cart_inventory", () -> IMenuTypeExtension.create(FuelCartInventoryMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CargoCatInventoryMenu>> CARGO_CAT_INVENTORY = REGISTRY.register("cargo_cat_inventory", () -> IMenuTypeExtension.create(CargoCatInventoryMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DrillCartInventoryMenu>> DRILL_CART_INVENTORY = REGISTRY.register("drill_cart_inventory", () -> IMenuTypeExtension.create(DrillCartInventoryMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SimpleBackpackGUIMenu>> SIMPLE_BACKPACK_GUI = REGISTRY.register("simple_backpack_gui", () -> IMenuTypeExtension.create(SimpleBackpackGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DiamondBackpackGUIMenu>> DIAMOND_BACKPACK_GUI = REGISTRY.register("diamond_backpack_gui", () -> IMenuTypeExtension.create(DiamondBackpackGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AttributeChangerMenu>> ATTRIBUTE_CHANGER = REGISTRY.register("attribute_changer", () -> IMenuTypeExtension.create(AttributeChangerMenu::new));
}
