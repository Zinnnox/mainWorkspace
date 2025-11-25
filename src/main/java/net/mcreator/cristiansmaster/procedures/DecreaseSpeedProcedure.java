package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.Entity;

public class DecreaseSpeedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ChangeSpeedProcedure.execute(entity, -0.01);
	}
}
