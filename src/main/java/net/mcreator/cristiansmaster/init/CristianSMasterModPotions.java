
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, CristianSMasterMod.MODID);
	public static final DeferredHolder<Potion, Potion> RANDOMIZER_POTION = REGISTRY.register("randomizer_potion", () -> new Potion(new MobEffectInstance(CristianSMasterModMobEffects.RANDOMIZE_MOB_HEIGHT_EFFECT, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> XRAY_POTION = REGISTRY.register("xray_potion", () -> new Potion(new MobEffectInstance(CristianSMasterModMobEffects.X_RAY, 3600, 0, false, true)));
}
