package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class DisplayManaOverlayProcedure {
	public static String execute(LevelAccessor world) {
		return "Mana: " + new java.text.DecimalFormat("##.##").format(CristianSMasterModVariables.MapVariables.get(world).Mana);
	}
}
