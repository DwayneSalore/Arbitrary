package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artbitrary.init.ArtbitraryModMobEffects;

public class PiercingLightProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ArtbitraryModMobEffects.PIERCED.get(), 100, 0, false, false));
	}
}
