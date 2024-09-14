package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.CristianSMasterMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RegenerateManaProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (CristianSMasterModVariables.MapVariables.get(world).Mana < 100) {
			CristianSMasterMod.queueServerWork(1, () -> {
				CristianSMasterModVariables.MapVariables.get(world).Mana = CristianSMasterModVariables.MapVariables.get(world).Mana + 1;
				CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
