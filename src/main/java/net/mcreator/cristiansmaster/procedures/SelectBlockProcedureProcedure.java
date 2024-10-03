package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

import java.util.HashMap;

public class SelectBlockProcedureProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.containsKey("checkbox:dirtCheck") && ((Checkbox) guistate.get("checkbox:dirtCheck")).selected()) {
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.selectedBlock = Blocks.DIRT.defaultBlockState();
				_vars.syncPlayerVariables(entity);
			}
		} else if (guistate.containsKey("checkbox:stoneCheck") && ((Checkbox) guistate.get("checkbox:stoneCheck")).selected()) {
			{
				CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
				_vars.selectedBlock = Blocks.STONE.defaultBlockState();
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
