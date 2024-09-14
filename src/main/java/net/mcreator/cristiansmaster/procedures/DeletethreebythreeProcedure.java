package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.CristianSMasterMod;

public class DeletethreebythreeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sz = 0;
		double sx = 0;
		double sy = 0;
		double dx = 0;
		double dz = 0;
		double dy = 0;
		dy = -2;
		for (int index0 = 0; index0 < 3; index0++) {
			dy = dy + 1;
			CristianSMasterMod.LOGGER.info(dy);
			world.destroyBlock(BlockPos.containing(x, y + dy, z), false);
		}
	}
}
