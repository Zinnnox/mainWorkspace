package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class DragonOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).i == 1 && entity.isVehicle()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (0.2 + entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
		} else {
			CristianSMasterMod.queueServerWork(20, () -> {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.2), (entity.getDeltaMovement().z())));
			});
		}
	}
}
