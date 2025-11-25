package net.mcreator.cristiansmaster.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class RandomizeMobHeightEffectEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double scale = 0;
		scale = Mth.nextDouble(RandomSource.create(), 0.1, 3);
		ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.MULTIPLY.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), scale));
		ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.MULTIPLY.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), scale));
	}
}
