package net.mcreator.artbitrary.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.artbitrary.init.ArtbitraryModParticleTypes;

public class SlashMakeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double radianArc = 0;
		double d = 0;
		double verticalOffset = 0;
		double sign = 0;
		double rollAngle = 0;
		double horizontalOffsetDir = 0;
		double i = 0;
		double dMajor = 0;
		double horizontalOffsetMag = 0;
		double circleDistanceConstant = 0;
		double radianSteps = 0;
		double arcStart = 0;
		if (true) {
			circleDistanceConstant = 1.3;
			rollAngle = 135;
			horizontalOffsetMag = 0;
			horizontalOffsetDir = 0;
			verticalOffset = 0.3;
			dMajor = circleDistanceConstant;
			d = circleDistanceConstant * Math.cos(Math.toRadians(rollAngle));
			i = ((-1) * Math.PI) / 4;
			radianArc = (0.5 * Math.PI) / 1;
			radianSteps = (1 * Math.PI) / 16;
			arcStart = Math.toRadians(entity.getYRot() + 90);
			while (i <= radianArc) {
				if (0 > Math.sin(i)) {
					sign = -1;
				} else {
					sign = 1;
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ArtbitraryModParticleTypes.WHITE.get()),
							(dMajor * Math.cos(i) * Math.cos(arcStart) - d * Math.sin(i) * Math.sin(arcStart) + entity.getX() + horizontalOffsetMag * Math.sin(Math.toRadians(entity.getYRot() + 180 + horizontalOffsetDir))),
							(sign * Math.sqrt(Math.abs(Math.sin(Math.toRadians(rollAngle))) * (Math.pow(dMajor, 2) - Math.pow(dMajor * Math.cos(i), 2))) + entity.getY() + 1 + verticalOffset),
							(dMajor * Math.cos(i) * Math.sin(arcStart) + d * Math.sin(i) * Math.cos(arcStart) + entity.getZ() - horizontalOffsetMag * Math.cos(Math.toRadians(entity.getYRot() + 180 + horizontalOffsetDir))), 1, 0, 0, 0, 0);
				i = i + radianSteps;
			}
		}
	}
}
