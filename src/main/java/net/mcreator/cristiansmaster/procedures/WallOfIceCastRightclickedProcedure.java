package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

public class WallOfIceCastRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && entity.isShiftKeyDown()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			posX = x + -1;
			posY = y + -1;
			posZ = z + -1;
			for (int index0 = 0; index0 < 14; index0++) {
				for (int index1 = 0; index1 < 14; index1++) {
					for (int index2 = 0; index2 < 14; index2++) {
						{
							BlockPos _bp = BlockPos.containing(posX, posY, posZ);
							BlockState _bs = Blocks.FROSTED_ICE.defaultBlockState();
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
						posZ = posZ + 1;
					}
					posZ = z + -1;
					posX = posX + 1;
				}
				posZ = z + -1;
				posX = x + -1;
				posY = posY + 1;
			}
		}
	}
}
