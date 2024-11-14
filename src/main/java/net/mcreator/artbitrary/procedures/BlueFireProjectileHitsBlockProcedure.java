package net.mcreator.artbitrary.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class BlueFireProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) < 30) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, x, y, z, 20, 0.1, 0.1, 0.1, 0.1);
		}
		for (int index0 = 0; index0 < 6; index0++) {
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 3), y + Mth.nextInt(RandomSource.create(), 1, 3), z + Mth.nextInt(RandomSource.create(), 1, 3)), Blocks.SOUL_FIRE.defaultBlockState(), 3);
		}
	}
}
