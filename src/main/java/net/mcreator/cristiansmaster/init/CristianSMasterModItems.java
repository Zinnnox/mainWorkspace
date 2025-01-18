
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.cristiansmaster.item.inventory.TeleporterButtonInventoryCapability;
import net.mcreator.cristiansmaster.item.XRayAmuletItem;
import net.mcreator.cristiansmaster.item.WyrmPotionItem;
import net.mcreator.cristiansmaster.item.WindStaffItem;
import net.mcreator.cristiansmaster.item.WallOfIceCastItem;
import net.mcreator.cristiansmaster.item.TeleporterItem;
import net.mcreator.cristiansmaster.item.TeleporterButtonItem;
import net.mcreator.cristiansmaster.item.TNTDimensionItem;
import net.mcreator.cristiansmaster.item.SpawnerAnvilItem;
import net.mcreator.cristiansmaster.item.ShootTheExplodingProjectileItemItem;
import net.mcreator.cristiansmaster.item.RocketLauncherItem;
import net.mcreator.cristiansmaster.item.PortalShooterItem;
import net.mcreator.cristiansmaster.item.PhoenixFeatherItem;
import net.mcreator.cristiansmaster.item.OPAxeItem;
import net.mcreator.cristiansmaster.item.NewDimensionItem;
import net.mcreator.cristiansmaster.item.NerfGunItem;
import net.mcreator.cristiansmaster.item.NerfGun2Item;
import net.mcreator.cristiansmaster.item.MiningLaserItem;
import net.mcreator.cristiansmaster.item.MagicMirrorItem;
import net.mcreator.cristiansmaster.item.MagicArmorItem;
import net.mcreator.cristiansmaster.item.KillAuraItem;
import net.mcreator.cristiansmaster.item.IdontknowItem;
import net.mcreator.cristiansmaster.item.GrimoireItem;
import net.mcreator.cristiansmaster.item.FlyingCarpetItem;
import net.mcreator.cristiansmaster.item.FireworkStickItem;
import net.mcreator.cristiansmaster.item.FairyDustItem;
import net.mcreator.cristiansmaster.item.CloakingDeviceItem;
import net.mcreator.cristiansmaster.item.BurntPheonixFeathterItem;
import net.mcreator.cristiansmaster.item.BuildersWandItem;
import net.mcreator.cristiansmaster.item.BioScannerItem;
import net.mcreator.cristiansmaster.item.AntManWatchItem;
import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CristianSMasterMod.MODID);
	public static final DeferredItem<Item> DRAGON_SPAWN_EGG = REGISTRY.register("dragon_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.DRAGON, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> ANT_MAN_WATCH = REGISTRY.register("ant_man_watch", AntManWatchItem::new);
	public static final DeferredItem<Item> MINING_LASER = REGISTRY.register("mining_laser", MiningLaserItem::new);
	public static final DeferredItem<Item> TELEPORTER = REGISTRY.register("teleporter", TeleporterItem::new);
	public static final DeferredItem<Item> CLOAKING_DEVICE = REGISTRY.register("cloaking_device", CloakingDeviceItem::new);
	public static final DeferredItem<Item> NEW_DIMENSION = REGISTRY.register("new_dimension", NewDimensionItem::new);
	public static final DeferredItem<Item> MARYANN_THE_SLIME_SPAWN_EGG = REGISTRY.register("maryann_the_slime_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.MARYANN_THE_SLIME, -10027162, -13434829, new Item.Properties()));
	public static final DeferredItem<Item> WYRM_POTION = REGISTRY.register("wyrm_potion", WyrmPotionItem::new);
	public static final DeferredItem<Item> BIO_SCANNER = REGISTRY.register("bio_scanner", BioScannerItem::new);
	public static final DeferredItem<Item> GRIMOIRE = REGISTRY.register("grimoire", GrimoireItem::new);
	public static final DeferredItem<Item> MAGIC_MIRROR = REGISTRY.register("magic_mirror", MagicMirrorItem::new);
	public static final DeferredItem<Item> IRONCLAD_SPAWN_EGG = REGISTRY.register("ironclad_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.IRONCLAD, -3407821, -13434880, new Item.Properties()));
	public static final DeferredItem<Item> FAIRY_DUST = REGISTRY.register("fairy_dust", FairyDustItem::new);
	public static final DeferredItem<Item> PHOENIX_FEATHER = REGISTRY.register("phoenix_feather", PhoenixFeatherItem::new);
	public static final DeferredItem<Item> BURNT_PHEONIX_FEATHTER = REGISTRY.register("burnt_pheonix_feathter", BurntPheonixFeathterItem::new);
	public static final DeferredItem<Item> MAGIC_ARMOR_HELMET = REGISTRY.register("magic_armor_helmet", MagicArmorItem.Helmet::new);
	public static final DeferredItem<Item> MAGIC_ARMOR_CHESTPLATE = REGISTRY.register("magic_armor_chestplate", MagicArmorItem.Chestplate::new);
	public static final DeferredItem<Item> MAGIC_ARMOR_LEGGINGS = REGISTRY.register("magic_armor_leggings", MagicArmorItem.Leggings::new);
	public static final DeferredItem<Item> MAGIC_ARMOR_BOOTS = REGISTRY.register("magic_armor_boots", MagicArmorItem.Boots::new);
	public static final DeferredItem<Item> NERF_GUN = REGISTRY.register("nerf_gun", NerfGunItem::new);
	public static final DeferredItem<Item> NERF_GUN_2 = REGISTRY.register("nerf_gun_2", NerfGun2Item::new);
	public static final DeferredItem<Item> TORNADO_SPAWN_EGG = REGISTRY.register("tornado_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.TORNADO, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> WIND_STAFF = REGISTRY.register("wind_staff", WindStaffItem::new);
	public static final DeferredItem<Item> SHOOT_THE_EXPLODING_PROJECTILE_ITEM = REGISTRY.register("shoot_the_exploding_projectile_item", ShootTheExplodingProjectileItemItem::new);
	public static final DeferredItem<Item> ROCKET_LAUNCHER = REGISTRY.register("rocket_launcher", RocketLauncherItem::new);
	public static final DeferredItem<Item> POP_SPAWN_EGG = REGISTRY.register("pop_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.POP, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> BIG_GUY_SPAWN_EGG = REGISTRY.register("big_guy_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.BIG_GUY, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> TNT_DIMENSION = REGISTRY.register("tnt_dimension", TNTDimensionItem::new);
	public static final DeferredItem<Item> IDONTKNOW = REGISTRY.register("idontknow", IdontknowItem::new);
	public static final DeferredItem<Item> OP_AXE = REGISTRY.register("op_axe", OPAxeItem::new);
	public static final DeferredItem<Item> WALL_OF_ICE_CAST = REGISTRY.register("wall_of_ice_cast", WallOfIceCastItem::new);
	public static final DeferredItem<Item> OUTLINE_SPAWN_EGG = REGISTRY.register("outline_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.OUTLINE, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> X_RAY_AMULET = REGISTRY.register("x_ray_amulet", XRayAmuletItem::new);
	public static final DeferredItem<Item> TELEPORTER_BUTTON = REGISTRY.register("teleporter_button", TeleporterButtonItem::new);
	public static final DeferredItem<Item> SPAWNER_ANVIL = REGISTRY.register("spawner_anvil", SpawnerAnvilItem::new);
	public static final DeferredItem<Item> BUILDERS_WAND = REGISTRY.register("builders_wand", BuildersWandItem::new);
	public static final DeferredItem<Item> FLYING_CARPET = REGISTRY.register("flying_carpet", FlyingCarpetItem::new);
	public static final DeferredItem<Item> PORTAL_ORANGE = block(CristianSMasterModBlocks.PORTAL_ORANGE);
	public static final DeferredItem<Item> PORTAL_BLUE = block(CristianSMasterModBlocks.PORTAL_BLUE);
	public static final DeferredItem<Item> PORTAL_SHOOTER = REGISTRY.register("portal_shooter", PortalShooterItem::new);
	public static final DeferredItem<Item> BONNIE_SPAWN_EGG = REGISTRY.register("bonnie_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.BONNIE, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> KILL_AURA = REGISTRY.register("kill_aura", KillAuraItem::new);
	public static final DeferredItem<Item> FIREWORK_STICK = REGISTRY.register("firework_stick", FireworkStickItem::new);
	public static final DeferredItem<Item> DRILL_CART = block(CristianSMasterModBlocks.DRILL_CART);
	public static final DeferredItem<Item> CARGO_CART = block(CristianSMasterModBlocks.CARGO_CART);
	public static final DeferredItem<Item> FUEL_CART = block(CristianSMasterModBlocks.FUEL_CART);

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new TeleporterButtonInventoryCapability(stack), TELEPORTER_BUTTON.get());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
