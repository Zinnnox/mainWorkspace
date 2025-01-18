package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

public class CargoCartOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		CargoNorthProcedure.execute(world, x, y, z, blockstate);
		CargoEastProcedure.execute(world, x, y, z, blockstate);
		CargoSouthProcedure.execute(world, x, y, z);
		CargoWestProcedure.execute(world, x, y, z);
	}
}
