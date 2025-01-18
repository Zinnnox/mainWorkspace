
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, CristianSMasterMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CUSTOM_FIREWORK = REGISTRY.register("custom_firework", () -> new SimpleParticleType(false));
}
