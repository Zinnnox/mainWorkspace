package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.cristiansmaster.entity.BloodyGolemEntity;

public class BloodyGolemEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 30 && !(entity instanceof BloodyGolemEntity _datEntL1 && _datEntL1.getEntityData().get(BloodyGolemEntity.DATA_berserk))) {
			if (entity instanceof BloodyGolemEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BloodyGolemEntity.DATA_berserk, true);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(80);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 240, 1));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 240, 1));
		}
	}
}
