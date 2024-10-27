package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

public class EdibleIronIngotPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 500, 3, false, false));
		{
			boolean _setval = true;
			entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ironman = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
