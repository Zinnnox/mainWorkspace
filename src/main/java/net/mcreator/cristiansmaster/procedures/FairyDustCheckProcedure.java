package net.mcreator.cristiansmaster.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class FairyDustCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).Mana >= 25) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("cristian_s_master:alert")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("cristian_s_master:alert")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			CristianSMasterModVariables.MapVariables.get(world).Mana = CristianSMasterModVariables.MapVariables.get(world).Mana - 25;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.DIVIDE.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), 5));
			ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.DIVIDE.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), 5));
			CristianSMasterMod.queueServerWork(500, () -> {
			});
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough mana!"), true);
		}
	}
}
