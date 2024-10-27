package net.mcreator.artbitrary.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ImmunityProcedure {
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
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).immunity == false) {
			if (entity.isShiftKeyDown()) {
				{
					double _setval = entity.getYRot() * entity.getXRot();
					entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Immunity = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.immunity = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
