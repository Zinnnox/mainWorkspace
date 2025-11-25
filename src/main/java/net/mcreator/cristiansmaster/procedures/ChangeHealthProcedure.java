package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ChangeHealthProcedure {
	public static void execute(Entity target, double delta) {
		if (target == null)
			return;
		if (target instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
			_livingEntity1.getAttribute(Attributes.MAX_HEALTH)
					.setBaseValue(((target instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity0.getAttribute(Attributes.MAX_HEALTH).getValue() : 0) + delta));
	}
}
