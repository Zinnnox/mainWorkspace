package net.mcreator.cristiansmaster.procedures;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class CloakingDeviceItemInInventoryTickProcedure {
	public static void execute() {
		if (CristianSMasterModVariables.CloakingCooldown > 0) {
			CristianSMasterModVariables.CloakingCooldown = CristianSMasterModVariables.CloakingCooldown - 1;
		}
	}
}
