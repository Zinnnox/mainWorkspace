
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.cristiansmaster.item.XRayAmuletItem;
import net.mcreator.cristiansmaster.item.WyrmPotionItem;
import net.mcreator.cristiansmaster.item.WindStaffItem;
import net.mcreator.cristiansmaster.item.WallOfIceCastItem;
import net.mcreator.cristiansmaster.item.TeleporterItem;
import net.mcreator.cristiansmaster.item.TNTDimensionItem;
import net.mcreator.cristiansmaster.item.SwordThatShootsItem;
import net.mcreator.cristiansmaster.item.ShootTheExplodingProjectileItemItem;
import net.mcreator.cristiansmaster.item.ScrapMetalItem;
import net.mcreator.cristiansmaster.item.RocketLauncherItem;
import net.mcreator.cristiansmaster.item.PhoenixFeatherItem;
import net.mcreator.cristiansmaster.item.OPAxeItem;
import net.mcreator.cristiansmaster.item.NukerAxeItem;
import net.mcreator.cristiansmaster.item.NewPortalGunItem;
import net.mcreator.cristiansmaster.item.NewDimensionItem;
import net.mcreator.cristiansmaster.item.NerfGunItem;
import net.mcreator.cristiansmaster.item.NerfGun2Item;
import net.mcreator.cristiansmaster.item.MoonDimensionPortalGunItem;
import net.mcreator.cristiansmaster.item.MiningLaserItem;
import net.mcreator.cristiansmaster.item.MagicMirrorItem;
import net.mcreator.cristiansmaster.item.MagicArmorItem;
import net.mcreator.cristiansmaster.item.LightsaberItem;
import net.mcreator.cristiansmaster.item.IdontknowItem;
import net.mcreator.cristiansmaster.item.HeloItem;
import net.mcreator.cristiansmaster.item.GrimoireItem;
import net.mcreator.cristiansmaster.item.FairyDustItem;
import net.mcreator.cristiansmaster.item.CloakingDeviceItem;
import net.mcreator.cristiansmaster.item.BurntPheonixFeathterItem;
import net.mcreator.cristiansmaster.item.BioScannerItem;
import net.mcreator.cristiansmaster.item.BackpackItem;
import net.mcreator.cristiansmaster.item.AntManWatchItem;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, CristianSMasterMod.MODID);
	public static final DeferredHolder<Item, Item> DRAGON_SPAWN_EGG = REGISTRY.register("dragon_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.DRAGON, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> SWORD_THAT_SHOOTS = REGISTRY.register("sword_that_shoots", SwordThatShootsItem::new);
	public static final DeferredHolder<Item, Item> NUKER_AXE = REGISTRY.register("nuker_axe", NukerAxeItem::new);
	public static final DeferredHolder<Item, Item> ANT_MAN_WATCH = REGISTRY.register("ant_man_watch", AntManWatchItem::new);
	public static final DeferredHolder<Item, Item> MINING_LASER = REGISTRY.register("mining_laser", MiningLaserItem::new);
	public static final DeferredHolder<Item, Item> TELEPORTER = REGISTRY.register("teleporter", TeleporterItem::new);
	public static final DeferredHolder<Item, Item> CLOAKING_DEVICE = REGISTRY.register("cloaking_device", CloakingDeviceItem::new);
	public static final DeferredHolder<Item, Item> MOON_DIMENSION_PORTAL_GUN = REGISTRY.register("moon_dimension_portal_gun", MoonDimensionPortalGunItem::new);
	public static final DeferredHolder<Item, Item> LIGHTSABER = REGISTRY.register("lightsaber", LightsaberItem::new);
	public static final DeferredHolder<Item, Item> NEW_DIMENSION = REGISTRY.register("new_dimension", NewDimensionItem::new);
	public static final DeferredHolder<Item, Item> NEW_PORTAL_GUN = REGISTRY.register("new_portal_gun", NewPortalGunItem::new);
	public static final DeferredHolder<Item, Item> MARYANN_THE_SLIME_SPAWN_EGG = REGISTRY.register("maryann_the_slime_spawn_egg",
			() -> new DeferredSpawnEggItem(CristianSMasterModEntities.MARYANN_THE_SLIME, -10027162, -13434829, new Item.Properties()));
	public static final DeferredHolder<Item, Item> HELLO_SPAWN_EGG = REGISTRY.register("hello_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.HELLO, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> REPLICATOR = block(CristianSMasterModBlocks.REPLICATOR);
	public static final DeferredHolder<Item, Item> SCRAP_METAL = REGISTRY.register("scrap_metal", ScrapMetalItem::new);
	public static final DeferredHolder<Item, Item> HELO = REGISTRY.register("helo", HeloItem::new);
	public static final DeferredHolder<Item, Item> WYRM_POTION = REGISTRY.register("wyrm_potion", WyrmPotionItem::new);
	public static final DeferredHolder<Item, Item> BIO_SCANNER = REGISTRY.register("bio_scanner", BioScannerItem::new);
	public static final DeferredHolder<Item, Item> GRIMOIRE = REGISTRY.register("grimoire", GrimoireItem::new);
	public static final DeferredHolder<Item, Item> MAGIC_MIRROR = REGISTRY.register("magic_mirror", MagicMirrorItem::new);
	public static final DeferredHolder<Item, Item> IRONCLAD_SPAWN_EGG = REGISTRY.register("ironclad_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.IRONCLAD, -3407821, -13434880, new Item.Properties()));
	public static final DeferredHolder<Item, Item> FAIRY_DUST = REGISTRY.register("fairy_dust", FairyDustItem::new);
	public static final DeferredHolder<Item, Item> PHOENIX_FEATHER = REGISTRY.register("phoenix_feather", PhoenixFeatherItem::new);
	public static final DeferredHolder<Item, Item> BURNT_PHEONIX_FEATHTER = REGISTRY.register("burnt_pheonix_feathter", BurntPheonixFeathterItem::new);
	public static final DeferredHolder<Item, Item> MAGIC_ARMOR_HELMET = REGISTRY.register("magic_armor_helmet", MagicArmorItem.Helmet::new);
	public static final DeferredHolder<Item, Item> MAGIC_ARMOR_CHESTPLATE = REGISTRY.register("magic_armor_chestplate", MagicArmorItem.Chestplate::new);
	public static final DeferredHolder<Item, Item> MAGIC_ARMOR_LEGGINGS = REGISTRY.register("magic_armor_leggings", MagicArmorItem.Leggings::new);
	public static final DeferredHolder<Item, Item> MAGIC_ARMOR_BOOTS = REGISTRY.register("magic_armor_boots", MagicArmorItem.Boots::new);
	public static final DeferredHolder<Item, Item> NERF_GUN = REGISTRY.register("nerf_gun", NerfGunItem::new);
	public static final DeferredHolder<Item, Item> NERF_GUN_2 = REGISTRY.register("nerf_gun_2", NerfGun2Item::new);
	public static final DeferredHolder<Item, Item> TORNADO_SPAWN_EGG = REGISTRY.register("tornado_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.TORNADO, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> WIND_STAFF = REGISTRY.register("wind_staff", WindStaffItem::new);
	public static final DeferredHolder<Item, Item> SHOOT_THE_EXPLODING_PROJECTILE_ITEM = REGISTRY.register("shoot_the_exploding_projectile_item", ShootTheExplodingProjectileItemItem::new);
	public static final DeferredHolder<Item, Item> ROCKET_LAUNCHER = REGISTRY.register("rocket_launcher", RocketLauncherItem::new);
	public static final DeferredHolder<Item, Item> POP_SPAWN_EGG = REGISTRY.register("pop_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.POP, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> BIG_GUY_SPAWN_EGG = REGISTRY.register("big_guy_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.BIG_GUY, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> TNT_DIMENSION = REGISTRY.register("tnt_dimension", TNTDimensionItem::new);
	public static final DeferredHolder<Item, Item> IDONTKNOW = REGISTRY.register("idontknow", IdontknowItem::new);
	public static final DeferredHolder<Item, Item> OP_AXE = REGISTRY.register("op_axe", OPAxeItem::new);
	public static final DeferredHolder<Item, Item> WALL_OF_ICE_CAST = REGISTRY.register("wall_of_ice_cast", WallOfIceCastItem::new);
	public static final DeferredHolder<Item, Item> OUTLINE_SPAWN_EGG = REGISTRY.register("outline_spawn_egg", () -> new DeferredSpawnEggItem(CristianSMasterModEntities.OUTLINE, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> X_RAY_AMULET = REGISTRY.register("x_ray_amulet", XRayAmuletItem::new);
	public static final DeferredHolder<Item, Item> BACKPACK = REGISTRY.register("backpack", BackpackItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
