package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ResetAttributesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
			_livingEntity0.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.SNEAKING_SPEED))
			_livingEntity1.getAttribute(Attributes.SNEAKING_SPEED).setBaseValue(0.3);
		if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
			_livingEntity2.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.42);
	}
}
