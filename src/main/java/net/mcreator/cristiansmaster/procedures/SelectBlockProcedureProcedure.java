package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

import java.util.HashMap;

public class SelectBlockProcedureProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			CristianSMasterModVariables.PlayerVariables _vars = entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
			_vars.selectedBlock = BuiltInRegistries.BLOCK.get(new ResourceLocation((("minecraft:" + (guistate.containsKey("text:input") ? ((EditBox) guistate.get("text:input")).getValue() : "").toLowerCase())).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
			_vars.syncPlayerVariables(entity);
		}
	}
}
