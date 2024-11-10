package net.mcreator.artbitrary.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.artbitrary.init.ArtbitraryModParticleTypes;

public class PiercingLightWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ArtbitraryModParticleTypes.YELLOW.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 30), 0.1, 0.1, 0.1, 0.5);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ArtbitraryModParticleTypes.YELLOW_1.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 30), 0.1, 0.1, 0.1, 0.5);
		if (immediatesourceentity.getPersistentData().getDouble("PierceLightTime") == 0) {
			immediatesourceentity.getPersistentData().putDouble("PierceLightTime", 150);
		} else {
			immediatesourceentity.getPersistentData().putDouble("PierceLightTime", (immediatesourceentity.getPersistentData().getDouble("PierceLightTime") - 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("PierceLightTime") == 0) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
