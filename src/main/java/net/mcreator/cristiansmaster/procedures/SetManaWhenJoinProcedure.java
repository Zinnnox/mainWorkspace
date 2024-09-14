package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetManaWhenJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		CristianSMasterModVariables.MapVariables.get(world).Mana = 100;
		CristianSMasterModVariables.MapVariables.get(world).syncData(world);
	}
}
