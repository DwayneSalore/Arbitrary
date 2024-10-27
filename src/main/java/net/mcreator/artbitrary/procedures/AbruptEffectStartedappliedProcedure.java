package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class AbruptEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("locationX", (entity.getX()));
		entity.getPersistentData().putDouble("locationY", (entity.getY()));
		entity.getPersistentData().putDouble("locationZ", (entity.getZ()));
		entity.getPersistentData().putDouble("pitchentity", (entity.getXRot()));
		entity.getPersistentData().putDouble("yawentity", (entity.getYRot()));
		if (entity instanceof Mob _mob) {
			_mob.setNoAi(true);
		}
	}
}
