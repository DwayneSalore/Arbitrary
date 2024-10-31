package net.mcreator.artbitrary.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StaminaStandStillProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).PhysicalAttunement == true) {
			if (!(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D)) {
				if (entity.getPersistentData().getDouble("StaminaRegen") == 0) {
					entity.getPersistentData().putDouble("StaminaRegen", 100);
				} else {
					entity.getPersistentData().putDouble("StaminaRegen", (entity.getPersistentData().getDouble("StaminaRegen") - 1));
				}
				if (entity.getPersistentData().getDouble("StaminaRegen") == 0) {
					if (entity.getPersistentData().getDouble("StaminaRegen") == 0) {
						{
							double _setval = (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).PhysicalStamina + 1;
							entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PhysicalStamina = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
