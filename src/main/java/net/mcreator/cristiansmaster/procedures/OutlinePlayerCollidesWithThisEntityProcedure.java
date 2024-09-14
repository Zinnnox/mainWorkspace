package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.Entity;

public class OutlinePlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
