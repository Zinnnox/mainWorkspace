
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.potion.XRayMobEffect;
import net.mcreator.cristiansmaster.potion.RandomizeMobHeightEffectMobEffect;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, CristianSMasterMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> RANDOMIZE_MOB_HEIGHT_EFFECT = REGISTRY.register("randomize_mob_height_effect", () -> new RandomizeMobHeightEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> X_RAY = REGISTRY.register("x_ray", () -> new XRayMobEffect());
}
