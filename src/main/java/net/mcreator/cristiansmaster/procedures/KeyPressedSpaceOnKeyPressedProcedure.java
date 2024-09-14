package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class KeyPressedSpaceOnKeyPressedProcedure {
	public static void execute(LevelAccessor world) {
		double pressed = 0;
		CristianSMasterModVariables.MapVariables.get(world).i = 1;
		CristianSMasterModVariables.MapVariables.get(world).syncData(world);
	}
}
