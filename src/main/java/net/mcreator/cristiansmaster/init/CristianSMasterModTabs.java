
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CristianSMasterMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CUSTOM = REGISTRY.register("custom",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.cristian_s_master.custom")).icon(() -> new ItemStack(CristianSMasterModItems.SHOOT_THE_EXPLODING_PROJECTILE_ITEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CristianSMasterModItems.PORTAL_SHOOTER.get());
				tabData.accept(CristianSMasterModItems.BONNIE_SPAWN_EGG.get());
				tabData.accept(CristianSMasterModItems.KILL_AURA.get());
				tabData.accept(CristianSMasterModItems.FIREWORK_STICK.get());
				tabData.accept(CristianSMasterModBlocks.DRILL_CART.get().asItem());
				tabData.accept(CristianSMasterModBlocks.CARGO_CART.get().asItem());
				tabData.accept(CristianSMasterModBlocks.FUEL_CART.get().asItem());
				tabData.accept(CristianSMasterModBlocks.SIMPLE_DRILL_CART.get().asItem());
				tabData.accept(CristianSMasterModBlocks.SIMPLE_CARGO_CART.get().asItem());
				tabData.accept(CristianSMasterModBlocks.SIMPLE_FUEL_CART.get().asItem());
				tabData.accept(CristianSMasterModItems.SIMPLE_BACKPACL.get());
				tabData.accept(CristianSMasterModItems.DIAMOND_BACKPACK.get());
				tabData.accept(CristianSMasterModBlocks.TEST_BLOCK.get().asItem());
				tabData.accept(CristianSMasterModItems.EYELASERCANNON.get());
				tabData.accept(CristianSMasterModBlocks.FRIEND.get().asItem());
				tabData.accept(CristianSMasterModItems.BOUNCY_BALL_ITEM.get());
				tabData.accept(CristianSMasterModItems.REMOTE.get());
				tabData.accept(CristianSMasterModItems.HOMING_ROCKET.get());
				tabData.accept(CristianSMasterModItems.SPRING_JUMPER.get());
				tabData.accept(CristianSMasterModItems.TNT_FILLER.get());
				tabData.accept(CristianSMasterModItems.REDSTONE_BATTERY.get());
				tabData.accept(CristianSMasterModItems.ORE_LOCATOR.get());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGIC_CREATIVE_TAB = REGISTRY.register("magic_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.cristian_s_master.magic_creative_tab")).icon(() -> new ItemStack(CristianSMasterModItems.IRONCLAD_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CristianSMasterModItems.TEMPLATE_STAFF.get());
				tabData.accept(CristianSMasterModItems.FIRE_STAFF.get());
				tabData.accept(CristianSMasterModItems.LIGHTNING_STAFF.get());
			}).withSearchBar().withTabsBefore(CUSTOM.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> POKEMON = REGISTRY.register("pokemon",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.cristian_s_master.pokemon")).icon(() -> new ItemStack(CristianSMasterModItems.EMPTY_POKEBALL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CristianSMasterModItems.EMPTY_POKEBALL.get());
				tabData.accept(CristianSMasterModItems.FILLED_POKEBALL.get());
			}).withSearchBar().withTabsBefore(MAGIC_CREATIVE_TAB.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(CristianSMasterModItems.DRAGON_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.MARYANN_THE_SLIME_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.IRONCLAD_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.TORNADO_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.POP_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.BIG_GUY_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.OUTLINE_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.EVIL_GOLEM_1_SPAWN_EGG.get());
			tabData.accept(CristianSMasterModItems.EVIL_GOLEM_2_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(CristianSMasterModItems.ANT_MAN_WATCH.get());
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
			tabData.accept(CristianSMasterModItems.XRAY_ARMOR_HELMET.get());
			tabData.accept(CristianSMasterModItems.SPRING_BOOTS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(CristianSMasterModItems.MINING_LASER.get());
			tabData.accept(CristianSMasterModItems.TELEPORTER.get());
			tabData.accept(CristianSMasterModItems.CLOAKING_DEVICE.get());
			tabData.accept(CristianSMasterModItems.NEW_DIMENSION.get());
			tabData.accept(CristianSMasterModItems.BIO_SCANNER.get());
			tabData.accept(CristianSMasterModItems.WIND_STAFF.get());
			tabData.accept(CristianSMasterModItems.TNT_DIMENSION.get());
			tabData.accept(CristianSMasterModItems.OP_AXE.get());
			tabData.accept(CristianSMasterModItems.WALL_OF_ICE_CAST.get());
			tabData.accept(CristianSMasterModItems.X_RAY_AMULET.get());
			tabData.accept(CristianSMasterModItems.TELEPORTER_BUTTON.get());
			tabData.accept(CristianSMasterModItems.BETTER_AXE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(CristianSMasterModItems.WYRM_POTION.get());
			tabData.accept(CristianSMasterModItems.FAIRY_DUST.get());
			tabData.accept(CristianSMasterModItems.PHOENIX_FEATHER.get());
			tabData.accept(CristianSMasterModItems.BURNT_PHEONIX_FEATHTER.get());
		}
	}
}
