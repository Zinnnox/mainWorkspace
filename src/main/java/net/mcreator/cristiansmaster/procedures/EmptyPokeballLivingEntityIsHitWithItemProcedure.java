package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class EmptyPokeballLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity pokemon = null;
		pokemon = entity;
		if (!CristianSMasterModVariables.MapVariables.get(world).hasCaptured) {
			CristianSMasterModVariables.MapVariables.get(world).capturedPokemon = pokemon.getDisplayName().getString();
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			CristianSMasterModVariables.MapVariables.get(world).hasCaptured = true;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon " + CristianSMasterModVariables.MapVariables.get(world).capturedPokemon));
			CristianSMasterModVariables.MapVariables.get(world).hasCaptured = false;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
