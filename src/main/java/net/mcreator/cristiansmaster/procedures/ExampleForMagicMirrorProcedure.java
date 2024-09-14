package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class ExampleForMagicMirrorProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CristianSMasterModVariables.MapVariables.get(world).Mana >= 50) {
			CristianSMasterModVariables.MapVariables.get(world).Mana = CristianSMasterModVariables.MapVariables.get(world).Mana - 50;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			entity.setInvisible(true);
			CristianSMasterMod.queueServerWork(300, () -> {
				entity.setInvisible(false);
			});
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough mana!"), true);
		}
	}
}
