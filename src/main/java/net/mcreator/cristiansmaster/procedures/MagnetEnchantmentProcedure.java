package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.Comparator;

public class MagnetEnchantmentProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double itemPosZ = 0;
		double itemPosY = 0;
		double itemPosX = 0;
		double playerPosY = 0;
		double playerPosZ = 0;
		double playerPosX = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0) {
			playerPosX = entity.getX();
			playerPosY = entity.getY();
			playerPosZ = entity.getZ();
			{
				final Vec3 _center = new Vec3(playerPosX, playerPosY, playerPosZ);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ItemEntity) {
						itemPosX = entityiterator.getX();
						itemPosY = entityiterator.getY();
						itemPosZ = entityiterator.getZ();
						if (itemPosX < playerPosX) {
							entityiterator.setDeltaMovement(new Vec3(0.25, (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
						} else if (itemPosX > playerPosX) {
							entityiterator.setDeltaMovement(new Vec3((-0.25), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
						}
						if (itemPosY < playerPosY) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.25, (entityiterator.getDeltaMovement().z())));
						} else if (itemPosY > playerPosY) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (-0.25), (entityiterator.getDeltaMovement().z())));
						}
						if (itemPosZ < playerPosZ) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), 0.25));
						} else if (itemPosZ > playerPosZ) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (-0.25)));
						}
					}
				}
			}
		}
	}
}
