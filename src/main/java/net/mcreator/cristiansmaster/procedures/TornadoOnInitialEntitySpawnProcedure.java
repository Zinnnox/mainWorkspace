package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Comparator;

public class TornadoOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity entityNear = null;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ASH, x, y, z, 5, 3, 3, 3, 1);
		entityNear = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(entityNear instanceof Player)) {
			{
				Entity _ent = entityNear;
				_ent.teleportTo(x, (y + 100), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 100), z, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
