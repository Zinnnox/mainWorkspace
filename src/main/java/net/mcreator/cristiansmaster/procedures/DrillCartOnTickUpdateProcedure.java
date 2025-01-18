package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DrillCartOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "IsBlockOn")) {
			DrillNorthScriptProcedure.execute(world, x, y, z, blockstate);
			DrillSouthScriptProcedure.execute(world, x, y, z, blockstate);
			DrillWestScriptProcedure.execute(world, x, y, z, blockstate);
			DrillEastScriptProcedure.execute(world, x, y, z, blockstate);
		}
	}
}
