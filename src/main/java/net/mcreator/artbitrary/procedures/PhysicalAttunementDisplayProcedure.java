package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

public class PhysicalAttunementDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).PhysicalAttunement == true) {
			return true;
		}
		return false;
	}
}