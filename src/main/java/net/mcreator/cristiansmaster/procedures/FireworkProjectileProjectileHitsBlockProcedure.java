package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.cristiansmaster.init.CristianSMasterModParticleTypes;

public class FireworkProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CristianSMasterModParticleTypes.CUSTOM_FIREWORK.get()), x, y, z, Mth.nextInt(RandomSource.create(), 1, 10), 2, 3, 2, 1);
	}
}
