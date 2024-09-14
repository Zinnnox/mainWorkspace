package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class KeyPressedSpaceOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world) {
		CristianSMasterModVariables.MapVariables.get(world).i = 0;
		CristianSMasterModVariables.MapVariables.get(world).syncData(world);
	}
}
