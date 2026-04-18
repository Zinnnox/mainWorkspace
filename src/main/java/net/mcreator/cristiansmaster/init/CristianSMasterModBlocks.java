
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.cristiansmaster.block.TestBlockBlock;
import net.mcreator.cristiansmaster.block.TNTDimensionPortalBlock;
import net.mcreator.cristiansmaster.block.SimpleFuelCartBlock;
import net.mcreator.cristiansmaster.block.SimpleDrillCartBlock;
import net.mcreator.cristiansmaster.block.SimpleCargoCartBlock;
import net.mcreator.cristiansmaster.block.PortalOrangeBlock;
import net.mcreator.cristiansmaster.block.PortalBlueBlock;
import net.mcreator.cristiansmaster.block.NewDimensionPortalBlock;
import net.mcreator.cristiansmaster.block.FuelCartBlock;
import net.mcreator.cristiansmaster.block.FriendBlock;
import net.mcreator.cristiansmaster.block.DrillCartBlock;
import net.mcreator.cristiansmaster.block.CargoCartBlock;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CristianSMasterMod.MODID);
	public static final DeferredBlock<Block> NEW_DIMENSION_PORTAL = REGISTRY.register("new_dimension_portal", NewDimensionPortalBlock::new);
	public static final DeferredBlock<Block> TNT_DIMENSION_PORTAL = REGISTRY.register("tnt_dimension_portal", TNTDimensionPortalBlock::new);
	public static final DeferredBlock<Block> PORTAL_ORANGE = REGISTRY.register("portal_orange", PortalOrangeBlock::new);
	public static final DeferredBlock<Block> PORTAL_BLUE = REGISTRY.register("portal_blue", PortalBlueBlock::new);
	public static final DeferredBlock<Block> DRILL_CART = REGISTRY.register("drill_cart", DrillCartBlock::new);
	public static final DeferredBlock<Block> CARGO_CART = REGISTRY.register("cargo_cart", CargoCartBlock::new);
	public static final DeferredBlock<Block> FUEL_CART = REGISTRY.register("fuel_cart", FuelCartBlock::new);
	public static final DeferredBlock<Block> SIMPLE_DRILL_CART = REGISTRY.register("simple_drill_cart", SimpleDrillCartBlock::new);
	public static final DeferredBlock<Block> SIMPLE_CARGO_CART = REGISTRY.register("simple_cargo_cart", SimpleCargoCartBlock::new);
	public static final DeferredBlock<Block> SIMPLE_FUEL_CART = REGISTRY.register("simple_fuel_cart", SimpleFuelCartBlock::new);
	public static final DeferredBlock<Block> TEST_BLOCK = REGISTRY.register("test_block", TestBlockBlock::new);
	public static final DeferredBlock<Block> FRIEND = REGISTRY.register("friend", FriendBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
