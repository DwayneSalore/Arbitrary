package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artbitrary.init.ArtbitraryModMobEffects;

public class BlueFireProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ArtbitraryModMobEffects.VULNERABILITY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArtbitraryModMobEffects.VULNERABILITY.get(), 400, 0, false, false));
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArtbitraryModMobEffects.VULNERABILITY.get(), 400, 0, false, false));
		}
		entity.setSecondsOnFire(8);
	}
}
