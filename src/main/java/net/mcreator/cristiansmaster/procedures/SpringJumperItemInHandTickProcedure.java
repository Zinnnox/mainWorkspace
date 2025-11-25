package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class SpringJumperItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double delta = 0;
		delta = 0.01;
		CristianSMasterModVariables.WorldVariables.get(world).ticks = CristianSMasterModVariables.WorldVariables.get(world).ticks + 1;
		CristianSMasterModVariables.WorldVariables.get(world).syncData(world);
		if (CristianSMasterModVariables.WorldVariables.get(world).ticks == 20) {
			CristianSMasterModVariables.WorldVariables.get(world).ticks = 0;
			CristianSMasterModVariables.WorldVariables.get(world).syncData(world);
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
				_livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)
						.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity0.getAttribute(Attributes.JUMP_STRENGTH).getValue() : 0) + delta));
		}
	}
}
