package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class BuildersWandItemInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("K: Select Block, Shift+M1: Position1, Shift+M2: Position 2, C: Fill"), true);
	}
}
