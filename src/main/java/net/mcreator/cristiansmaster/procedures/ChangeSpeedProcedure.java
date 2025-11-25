package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ChangeSpeedProcedure {
	public static void execute(Entity entity, double delta) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
			_livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED)
					.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity0.getAttribute(Attributes.MOVEMENT_SPEED).getValue() : 0) + delta));
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.SNEAKING_SPEED))
			_livingEntity3.getAttribute(Attributes.SNEAKING_SPEED)
					.setBaseValue(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.SNEAKING_SPEED) ? _livingEntity2.getAttribute(Attributes.SNEAKING_SPEED).getValue() : 0) + delta));
	}
}
