
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.cristiansmaster.block.TNTDimensionPortalBlock;
import net.mcreator.cristiansmaster.block.PortalOrangeBlock;
import net.mcreator.cristiansmaster.block.PortalBlueBlock;
import net.mcreator.cristiansmaster.block.NewDimensionPortalBlock;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CristianSMasterMod.MODID);
	public static final DeferredBlock<Block> NEW_DIMENSION_PORTAL = REGISTRY.register("new_dimension_portal", NewDimensionPortalBlock::new);
	public static final DeferredBlock<Block> TNT_DIMENSION_PORTAL = REGISTRY.register("tnt_dimension_portal", TNTDimensionPortalBlock::new);
	public static final DeferredBlock<Block> PORTAL_ORANGE = REGISTRY.register("portal_orange", PortalOrangeBlock::new);
	public static final DeferredBlock<Block> PORTAL_BLUE = REGISTRY.register("portal_blue", PortalBlueBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
