package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.block.MoonDimensionPortalBlock;

public class MoonDimensionPortalGunRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getProjectile(Level level, Entity shooter) {
					Projectile entityToSpawn = new ThrownEnderpearl(EntityType.ENDER_PEARL, level);
					entityToSpawn.setOwner(shooter);
					return entityToSpawn;
				}
			}.getProjectile(projectileLevel, entity);
			_entityToSpawn.setPos(x, y, z);
			_entityToSpawn.shoot(1, 1, 1, 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof Level _level)
			MoonDimensionPortalBlock.portalSpawn(_level, BlockPos.containing(x, y, z));
	}
}
