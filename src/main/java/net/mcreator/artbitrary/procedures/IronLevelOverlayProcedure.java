package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

public class IronLevelOverlayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).IronLevelOverlay;
	}
}
