package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = x - 1;
		sy = y - 1;
		world.setBlock(BlockPos.containing(sx, sy, z), Blocks.AIR.defaultBlockState(), 3);
		for (int index0 = 0; index0 < 2; index0++) {
			sy = sy + 1;
			world.setBlock(BlockPos.containing(sx, sy, z), Blocks.AIR.defaultBlockState(), 3);
		}
		sy = y - 1;
		for (int index1 = 0; index1 < 2; index1++) {
			sy = sy + 1;
			world.setBlock(BlockPos.containing(sx, sy, z), Blocks.AIR.defaultBlockState(), 3);
		}
		sx = x + 1;
		sy = y - 1;
		for (int index2 = 0; index2 < 2; index2++) {
			sy = sy + 1;
			world.setBlock(BlockPos.containing(sx, sy, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
