package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.block.MoonDimensionPortalBlock;

public class ShootToSpawnPortalProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level)
			MoonDimensionPortalBlock.portalSpawn(_level, BlockPos.containing(x, y, z));
	}
}
