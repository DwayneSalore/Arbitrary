package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;
import net.mcreator.artbitrary.init.ArtbitraryModMobEffects;

public class StaminaRegenOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("StaminaRegen") == 0) {
			entity.getPersistentData().putDouble("StaminaRegen", 20);
		} else {
			entity.getPersistentData().putDouble("StaminaRegen", (entity.getPersistentData().getDouble("StaminaRegen") - 1));
		}
		if (entity.getPersistentData().getDouble("StaminaRegen") == 0) {
			if (entity.getPersistentData().getDouble("StaminaRegen") == 0) {
				{
					double _setval = (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).PhysicalStamina + 1
							+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArtbitraryModMobEffects.STAMINA_REGEN.get()) ? _livEnt.getEffect(ArtbitraryModMobEffects.STAMINA_REGEN.get()).getAmplifier() : 0);
					entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PhysicalStamina = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
