package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class SpawnerAnvilRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			BlockPos _bp = BlockPos.containing(
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 5,
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
			BlockState _bs = Blocks.ANVIL.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
	}
}
