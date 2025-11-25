package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BetterAxeBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean isWood = false;
		double height = 0;
		isWood = true;
		height = 1;
		while (isWood) {
			if ((world.getBlockState(BlockPos.containing(x, y + height, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
				{
					BlockPos _pos = BlockPos.containing(x, y + height, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
				height = height + 1;
			} else {
				isWood = false;
			}
		}
	}
}
