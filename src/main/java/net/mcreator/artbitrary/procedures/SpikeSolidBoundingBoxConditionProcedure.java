package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.Entity;

public class SpikeSolidBoundingBoxConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isAlive()) {
			return true;
		}
		return false;
	}
}
