package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ChangeJumpProcedure {
	public static void execute(Entity entity, double delta) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
			_livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)
					.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity0.getAttribute(Attributes.JUMP_STRENGTH).getValue() : 0) + delta));
	}
}
