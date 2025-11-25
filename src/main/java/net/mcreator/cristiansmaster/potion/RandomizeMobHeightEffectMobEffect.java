
package net.mcreator.cristiansmaster.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;

import net.mcreator.cristiansmaster.procedures.RandomizeMobHeightEffectEffectStartedappliedProcedure;

public class RandomizeMobHeightEffectMobEffect extends InstantenousMobEffect {
	public RandomizeMobHeightEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		RandomizeMobHeightEffectEffectStartedappliedProcedure.execute(entity);
	}
}
