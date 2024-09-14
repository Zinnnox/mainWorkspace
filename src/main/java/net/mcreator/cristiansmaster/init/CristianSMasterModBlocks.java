
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;

import net.mcreator.cristiansmaster.block.TNTDimensionPortalBlock;
import net.mcreator.cristiansmaster.block.NewDimensionPortalBlock;
import net.mcreator.cristiansmaster.block.MoonDimensionPortalBlock;
import net.mcreator.cristiansmaster.block.JorBlock;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CristianSMasterMod.MODID);
	public static final DeferredHolder<Block, Block> MOON_DIMENSION_PORTAL = REGISTRY.register("moon_dimension_portal", MoonDimensionPortalBlock::new);
	public static final DeferredHolder<Block, Block> NEW_DIMENSION_PORTAL = REGISTRY.register("new_dimension_portal", NewDimensionPortalBlock::new);
	public static final DeferredHolder<Block, Block> REPLICATOR = REGISTRY.register("replicator", JorBlock::new);
	public static final DeferredHolder<Block, Block> TNT_DIMENSION_PORTAL = REGISTRY.register("tnt_dimension_portal", TNTDimensionPortalBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
