package net.mcreator.artbitrary.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artbitrary.init.ArtbitraryModParticleTypes;

public class BlueFireWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (ArtbitraryModParticleTypes.BLUE_1.get()), x, y, z, 0, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 8, 0.001, 0.001, 0.001, 0.001);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 2, 0.001, 0.001, 0.001, 0.1);
	}
}
