package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.init.CristianSMasterModEntities;

public class SpawnSillyGooseCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).Mana >= 99) {
			CristianSMasterModVariables.MapVariables.get(world).Mana = CristianSMasterModVariables.MapVariables.get(world).Mana - 1000;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CristianSMasterModEntities.MARYANN_THE_SLIME.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough mana!"), true);
		}
	}
}
