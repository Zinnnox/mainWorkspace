package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;

public class RemoteRightclickedProcedure {
	public static void execute(LevelAccessor world) {
		world.setBlock(BlockPos.containing(CristianSMasterModVariables.MapVariables.get(world).RemotePosX, CristianSMasterModVariables.MapVariables.get(world).RemotePosY, CristianSMasterModVariables.MapVariables.get(world).RemotePosZ),
				Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, CristianSMasterModVariables.MapVariables.get(world).RemotePosX, CristianSMasterModVariables.MapVariables.get(world).RemotePosY, CristianSMasterModVariables.MapVariables.get(world).RemotePosZ, 10,
					Level.ExplosionInteraction.TNT);
	}
}
