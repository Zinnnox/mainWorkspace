package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

public class FireworkProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.ELECTRIC_SPARK, x, y, z, (Mth.nextInt(RandomSource.create(), 1, 10)), (Mth.nextInt(RandomSource.create(), 1, 10)), (Mth.nextInt(RandomSource.create(), 1, 10)));
	}
}
