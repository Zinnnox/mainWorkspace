package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.init.CristianSMasterModBlocks;

public class NewPortalGunRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), CristianSMasterModBlocks.NEW_DIMENSION_PORTAL.get().defaultBlockState(), 3);
	}
}
