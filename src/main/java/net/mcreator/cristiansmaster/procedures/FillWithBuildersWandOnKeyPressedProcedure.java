package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.init.CristianSMasterModItems;

public class FillWithBuildersWandOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CristianSMasterModItems.BUILDERS_WAND.get()) {
			if (entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bwPosX != 0 && entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosX != 0) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("fill" + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bwPosX + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bwPosY + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bwPosZ
									+ entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosX + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosY + entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).bw2PosZ
									+ entity.getData(CristianSMasterModVariables.PLAYER_VARIABLES).selectedBlock));
			}
		}
	}
}
