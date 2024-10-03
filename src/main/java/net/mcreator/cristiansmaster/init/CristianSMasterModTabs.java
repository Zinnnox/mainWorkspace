
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CristianSMasterMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(CristianSMasterModBlocks.REPLICATOR.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(CristianSMasterModItems.SWORD_THAT_SHOOTS.get());
			tabData.accept(CristianSMasterModItems.ANT_MAN_WATCH.get());
			tabData.accept(CristianSMasterModItems.LIGHTSABER.get());
			tabData.accept(CristianSMasterModItems.GRIMOIRE.get());
			tabData.accept(CristianSMasterModItems.MAGIC_MIRROR.get());
			tabData.accept(CristianSMasterModItems.MAGIC_ARMOR_HELMET.get());
			tabData.accept(CristianSMasterModItems.MAGIC_ARMOR_CHESTPLATE.get());
			tabData.accept(CristianSMasterModItems.MAGIC_ARMOR_LEGGINGS.get());
			tabData.accept(CristianSMasterModItems.MAGIC_ARMOR_BOOTS.get());
			tabData.accept(CristianSMasterModItems.NERF_GUN.get());
			tabData.accept(CristianSMasterModItems.NERF_GUN_2.get());
			tabData.accept(CristianSMasterModItems.SHOOT_THE_EXPLODING_PROJECTILE_ITEM.get());
			tabData.accept(CristianSMasterModItems.ROCKET_LAUNCHER.get());
			tabData.accept(CristianSMasterModItems.IDONTKNOW.get());
			tabData.accept(CristianSMasterModItems.BUILDERS_WAND.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(CristianSMasterModItems.DRAGON_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.MARYANN_THE_SLIME_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.HELLO_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.IRONCLAD_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.TORNADO_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.POP_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.BIG_GUY_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.OUTLINE_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.TWOCOLOR_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(CristianSMasterModItems.SCRAP_METAL.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(CristianSMasterModItems.MINING_LASER.get());
			tabData.accept(CristianSMasterModItems.TELEPORTER.get());
			tabData.accept(CristianSMasterModItems.CLOAKING_DEVICE.get());
			tabData.accept(CristianSMasterModItems.MOON_DIMENSION_PORTAL_GUN.get());
			tabData.accept(CristianSMasterModItems.NEW_DIMENSION.get());
			tabData.accept(CristianSMasterModItems.NEW_PORTAL_GUN.get());
			tabData.accept(CristianSMasterModItems.HELO.get());
			tabData.accept(CristianSMasterModItems.BIO_SCANNER.get());
			tabData.accept(CristianSMasterModItems.WIND_STAFF.get());
			tabData.accept(CristianSMasterModItems.TNT_DIMENSION.get());
			tabData.accept(CristianSMasterModItems.OP_AXE.get());
			tabData.accept(CristianSMasterModItems.WALL_OF_ICE_CAST.get());
			tabData.accept(CristianSMasterModItems.X_RAY_AMULET.get());
			tabData.accept(CristianSMasterModItems.BACKPACK.get());
			tabData.accept(CristianSMasterModItems.TELEPORTER_BUTTON.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(CristianSMasterModItems.WYRM_POTION.get());
			tabData.accept(CristianSMasterModItems.FAIRY_DUST.get());
			tabData.accept(CristianSMasterModItems.PHOENIX_FEATHER.get());
			tabData.accept(CristianSMasterModItems.BURNT_PHEONIX_FEATHTER.get());
		}
	}
}
