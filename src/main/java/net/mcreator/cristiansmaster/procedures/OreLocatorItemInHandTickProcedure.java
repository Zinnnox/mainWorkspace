package net.mcreator.cristiansmaster.procedures;

import org.checkerframework.checker.units.qual.t;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class OreLocatorItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, double dist) {
		if (entity == null)
			return;
		double t = 0;
		double waitTime = 0;
		waitTime = 1 * 20;
		for (int index0 = 0; index0 < 10; index0++) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Distance to ore: " + dist)), true);
			if (CristianSMasterModVariables.MapVariables.get(world).globaltimer == waitTime) {
				CristianSMasterModVariables.MapVariables.get(world).globaltimer = 0;
				CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			} else {
				CristianSMasterModVariables.MapVariables.get(world).globaltimer = CristianSMasterModVariables.MapVariables.get(world).globaltimer + 1;
				CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
