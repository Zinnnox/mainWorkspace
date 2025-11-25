package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class GlobalWaitTimerProcedure {
	public static void execute(LevelAccessor world, double time) {
		double waitTime = 0;
		waitTime = time * 20;
		if (CristianSMasterModVariables.MapVariables.get(world).globaltimer == waitTime) {
			CristianSMasterModVariables.MapVariables.get(world).globaltimer = 0;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		} else {
			CristianSMasterModVariables.MapVariables.get(world).globaltimer = CristianSMasterModVariables.MapVariables.get(world).globaltimer + 1;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
