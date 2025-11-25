package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.Entity;

public class DecreaseJumpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ChangeJumpProcedure.execute(entity, -0.1);
	}
}
