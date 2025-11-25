package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.init.CristianSMasterModItems;
import net.mcreator.cristiansmaster.init.CristianSMasterModEntities;
import net.mcreator.cristiansmaster.entity.OutlineEntity;

public class XRayHelmetOnEveryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		boolean exists = false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == CristianSMasterModItems.XRAY_ARMOR_HELMET.get()) {
			posX = x - 20;
			posY = y - 20;
			posZ = z - 20;
			for (int index0 = 0; index0 < 40; index0++) {
				for (int index1 = 0; index1 < 40; index1++) {
					for (int index2 = 0; index2 < 40; index2++) {
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == Blocks.DIAMOND_ORE) {
							exists = !world.getEntitiesOfClass(OutlineEntity.class, AABB.ofSize(new Vec3(posX, posY, posZ), 1, 1, 1), e -> true).isEmpty();
							if (!exists) {
								{
									BlockPos _bp = BlockPos.containing(posX, posY + 1, posZ);
									BlockState _bs = Blocks.AIR.defaultBlockState();
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
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CristianSMasterModEntities.OUTLINE.get().spawn(_level, BlockPos.containing(posX + 0.5, posY, posZ + 0.5), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(90);
										entityToSpawn.setYBodyRot(90);
										entityToSpawn.setYHeadRot(90);
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
