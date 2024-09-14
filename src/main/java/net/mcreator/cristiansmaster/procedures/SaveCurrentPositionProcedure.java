package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class SaveCurrentPositionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CristianSMasterModVariables.MapVariables.get(world).tpPosX = entity.getX();
		CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		CristianSMasterModVariables.MapVariables.get(world).tpPosY = entity.getY();
		CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		CristianSMasterModVariables.MapVariables.get(world).tpPosZ = entity.getZ();
		CristianSMasterModVariables.MapVariables.get(world).syncData(world);
	}
}
