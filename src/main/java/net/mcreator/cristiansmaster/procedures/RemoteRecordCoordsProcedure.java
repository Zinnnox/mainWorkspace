package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RemoteRecordCoordsProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate == Blocks.TNT.defaultBlockState()) {
			CristianSMasterModVariables.MapVariables.get(world).RemotePosX = x;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			CristianSMasterModVariables.MapVariables.get(world).RemotePosY = y;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			CristianSMasterModVariables.MapVariables.get(world).RemotePosZ = z;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
