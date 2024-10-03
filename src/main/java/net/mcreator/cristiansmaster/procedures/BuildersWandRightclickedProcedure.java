package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class BuildersWandRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.bw2PosX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
				_vars.syncPlayerVariables(entity);
			}
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.bw2PosY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
				_vars.syncPlayerVariables(entity);
			}
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.bw2PosZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Position Two Saved as: " + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosX + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosY
						+ entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosZ)), true);
		}
	}
}
