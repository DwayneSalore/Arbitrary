package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class AbruptEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(false);
		if (entity instanceof Mob _mob) {
			_mob.setNoAi(false);
		}
	}
}
