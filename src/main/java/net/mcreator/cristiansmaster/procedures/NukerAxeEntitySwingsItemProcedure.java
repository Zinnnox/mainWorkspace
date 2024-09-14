package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class NukerAxeEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double particleRadius = 0;
		double particleAmount = 0;
		particleAmount = 4;
		particleRadius = 4;
		for (int index0 = 0; index0 < (int) particleAmount; index0++) {
			world.addParticle(ParticleTypes.GLOW, (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (y + 0 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
					(z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 0, 0, 0);
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.GRASS_BLOCK
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.GRASS_BLOCK
				|| (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.GRASS_BLOCK
				|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK)) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
		}
	}
}
