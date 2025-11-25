
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.procedures.RandomizeMobHeightEffectEffectExpiresProcedure;
import net.mcreator.cristiansmaster.potion.XRayMobEffect;
import net.mcreator.cristiansmaster.potion.RandomizeMobHeightEffectMobEffect;
import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber
public class CristianSMasterModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, CristianSMasterMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> RANDOMIZE_MOB_HEIGHT_EFFECT = REGISTRY.register("randomize_mob_height_effect", () -> new RandomizeMobHeightEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> X_RAY = REGISTRY.register("x_ray", () -> new XRayMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(RANDOMIZE_MOB_HEIGHT_EFFECT)) {
			RandomizeMobHeightEffectEffectExpiresProcedure.execute(entity);
		}
	}
}
