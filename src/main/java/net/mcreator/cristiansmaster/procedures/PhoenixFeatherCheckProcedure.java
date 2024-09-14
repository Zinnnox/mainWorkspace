package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.init.CristianSMasterModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PhoenixFeatherCheckProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).Mana >= 90 && CristianSMasterModVariables.MapVariables.get(world).hasPhoenixFeatherBeenUsed == 0 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 2
				&& CristianSMasterModItems.PHOENIX_FEATHER.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			CristianSMasterModVariables.MapVariables.get(world).hasPhoenixFeatherBeenUsed = 1;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			CristianSMasterModVariables.MapVariables.get(world).Mana = CristianSMasterModVariables.MapVariables.get(world).Mana - 500;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("cristian_s_master:phoenixcry")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("cristian_s_master:phoenixcry")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel)
				((ServerLevel) world).sendParticles((ParticleTypes.SOUL), x, (y + 1), z, 50, 3, 3, 3, 1);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(300);
			if (entity instanceof LivingEntity _livingEntity)
				_livingEntity.addEffect((new MobEffectInstance(MobEffects.ABSORPTION, 500, 10)));
			if (entity instanceof LivingEntity _livingEntity)
				_livingEntity.addEffect((new MobEffectInstance(MobEffects.GLOWING, 500, 10)));
			if (entity instanceof LivingEntity _livingEntity)
				_livingEntity.addEffect((new MobEffectInstance(MobEffects.REGENERATION, 500, 10)));
			if (entity instanceof LivingEntity _livingEntity)
				_livingEntity.addEffect((new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 10)));
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough mana!"), true);
		}
	}
}
