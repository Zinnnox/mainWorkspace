package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class BuildersWandRightclickedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.bw2PosX = x;
				_vars.syncPlayerVariables(entity);
			}
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.bw2PosY = y;
				_vars.syncPlayerVariables(entity);
			}
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.bw2PosZ = z;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Position Two Saved as: " + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosX + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosY
						+ entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosZ)), true);
		}
	}
}
