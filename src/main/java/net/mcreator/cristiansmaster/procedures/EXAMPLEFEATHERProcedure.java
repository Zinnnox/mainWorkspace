package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.cristiansmaster.init.CristianSMasterModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EXAMPLEFEATHERProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 2 && CristianSMasterModItems.PHOENIX_FEATHER.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
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
