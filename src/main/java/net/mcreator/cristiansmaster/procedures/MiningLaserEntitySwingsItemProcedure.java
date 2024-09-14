package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MiningLaserEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sz = 0;
		double sy = 0;
		double sx = 0;
		double above = 0;
		double under = 0;
		above = y + 1;
		under = y - 1;
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
			world.destroyBlock(_pos, false);
		}
		{
			BlockPos _pos = BlockPos.containing(x, above, z);
			Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
			world.destroyBlock(_pos, false);
		}
		{
			BlockPos _pos = BlockPos.containing(x, under, z);
			Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
			world.destroyBlock(_pos, false);
		}
	}
}
