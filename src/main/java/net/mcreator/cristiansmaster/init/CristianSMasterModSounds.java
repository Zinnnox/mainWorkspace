
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.CristianSMasterMod;

public class CristianSMasterModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, CristianSMasterMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_LAUGH = REGISTRY.register("evil_laugh", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "evil_laugh")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VANISHED = REGISTRY.register("vanished", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "vanished")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WYRMSPAWN = REGISTRY.register("wyrmspawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "wyrmspawn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FIREBALL = REGISTRY.register("fireball", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "fireball")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ICESHARD = REGISTRY.register("iceshard", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "iceshard")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MAGICMIRRORVANISH = REGISTRY.register("magicmirrorvanish", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "magicmirrorvanish")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REAPPEAR = REGISTRY.register("reappear", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "reappear")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ALERT = REGISTRY.register("alert", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "alert")));
	public static final DeferredHolder<SoundEvent, SoundEvent> IRONCLADAMBIENT = REGISTRY.register("ironcladambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "ironcladambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> IRONCLADSPAWN = REGISTRY.register("ironcladspawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "ironcladspawn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PHOENIXCRY = REGISTRY.register("phoenixcry", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "phoenixcry")));
}
