package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.cristiansmaster.CristianSMasterMod;

import java.util.ArrayList;

public class PlayerSpeedProcedure {
	public static void execute(LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			CristianSMasterMod.LOGGER.info(entityiterator instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity0.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
			if (entityiterator instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(5);
		}
	}
}
