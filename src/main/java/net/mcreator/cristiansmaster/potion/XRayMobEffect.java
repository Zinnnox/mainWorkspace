
package net.mcreator.cristiansmaster.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.cristiansmaster.procedures.XRayPotionEffectProcedure;

public class XRayMobEffect extends MobEffect {
	public XRayMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		XRayPotionEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
