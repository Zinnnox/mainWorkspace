package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class OPAxeBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			posX = x - 1;
			posY = y - 1;
			posZ = z - 1;
			for (int index0 = 0; index0 < 24; index0++) {
				for (int index1 = 0; index1 < 3; index1++) {
					for (int index2 = 0; index2 < 3; index2++) {
						if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("stopMining") == false) {
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
								{
									BlockPos _pos = BlockPos.containing(posX, posY, posZ);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(posX, posY, posZ), null);
									world.destroyBlock(_pos, false);
								}
								if (itemstack.getDamageValue() <= 0) {
									{
										final String _tagName = "stopMining";
										final boolean _tagValue = true;
										CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
									}
								}
							}
						}
						posZ = posZ + 1;
					}
					posZ = z - 1;
					posX = posX + 1;
				}
				posX = x - 1;
				posZ = z - 1;
				posY = posY + 1;
			}
		}
	}
}
