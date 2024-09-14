package net.mcreator.cristiansmaster.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class FairyDustCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).Mana >= 25) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("cristian_s_master:alert")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("cristian_s_master:alert")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			CristianSMasterModVariables.MapVariables.get(world).Mana = CristianSMasterModVariables.MapVariables.get(world).Mana - 25;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof LivingEntity _livingEntity)
				_livingEntity.addEffect((new MobEffectInstance(MobEffects.GLOWING, 200, 1)));
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/attribute Dev neoforge:creative_flight base set 1");
				}
			}
			if (world instanceof ServerLevel)
				((ServerLevel) world).sendParticles((ParticleTypes.EFFECT), x, (y + 1), z, 25, 3, 3, 3, 1);
			ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.DIVIDE.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), 5));
			ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.DIVIDE.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), 5));
			CristianSMasterMod.queueServerWork(500, () -> {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/attribute Dev neoforge:creative_flight base set 0");
					}
				}
			});
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough mana!"), true);
		}
	}
}
