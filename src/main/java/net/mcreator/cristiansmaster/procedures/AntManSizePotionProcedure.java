package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class AntManSizePotionProcedure {
	public static void execute(LevelAccessor world) {
		double usageCount = 0;
		if (CristianSMasterModVariables.MapVariables.get(world).usageCounter == 0) {
			CristianSMasterModVariables.MapVariables.get(world).usageCounter = 1;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		} else if (CristianSMasterModVariables.MapVariables.get(world).usageCounter == 1) {
			CristianSMasterModVariables.MapVariables.get(world).usageCounter = 0;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
