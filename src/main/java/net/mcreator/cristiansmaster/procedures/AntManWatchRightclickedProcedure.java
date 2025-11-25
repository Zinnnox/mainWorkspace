package net.mcreator.cristiansmaster.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class AntManWatchRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean state = false;
		if (CristianSMasterModVariables.MapVariables.get(world).hasRightClicked == false) {
			ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.MULTIPLY.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), 2));
			ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.MULTIPLY.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), 2));
			CristianSMasterModVariables.MapVariables.get(world).hasRightClicked = true;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		} else if (CristianSMasterModVariables.MapVariables.get(world).hasRightClicked == true) {
			ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.MULTIPLY.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), 0.5));
			ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.MULTIPLY.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), 0.5));
			CristianSMasterModVariables.MapVariables.get(world).hasRightClicked = false;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
