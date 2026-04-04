package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.cristiansmaster.entity.BloodyGolemEntity;

public class BloodyGolemPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof BloodyGolemEntity _datEntL0 && _datEntL0.getEntityData().get(BloodyGolemEntity.DATA_berserk)) == true;
	}
}
