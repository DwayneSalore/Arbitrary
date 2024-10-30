package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.Entity;

public class SpikeOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("SpikeDespawn") == 0) {
			entity.getPersistentData().putDouble("SpikeDespawn", 300);
		} else {
			entity.getPersistentData().putDouble("SpikeDespawn", (entity.getPersistentData().getDouble("SpikeDespawn") - 1));
		}
		if (entity.getPersistentData().getDouble("SpikeDespawn") == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
