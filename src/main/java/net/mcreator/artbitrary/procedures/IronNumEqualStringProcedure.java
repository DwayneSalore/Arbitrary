package net.mcreator.artbitrary.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IronNumEqualStringProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).IronLevel + "";
			entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IronLevelOverlay = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).IronResistance + "";
			entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IronResistanceOverlay = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
