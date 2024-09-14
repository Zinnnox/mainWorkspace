package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class TeleportToSavedPositionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(CristianSMasterModVariables.MapVariables.get(world).tpPosX, CristianSMasterModVariables.MapVariables.get(world).tpPosY, CristianSMasterModVariables.MapVariables.get(world).tpPosZ);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(CristianSMasterModVariables.MapVariables.get(world).tpPosX, CristianSMasterModVariables.MapVariables.get(world).tpPosY, CristianSMasterModVariables.MapVariables.get(world).tpPosZ, _ent.getYRot(),
						_ent.getXRot());
		}
	}
}
