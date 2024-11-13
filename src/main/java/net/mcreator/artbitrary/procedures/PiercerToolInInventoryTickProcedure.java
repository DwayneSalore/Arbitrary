package net.mcreator.artbitrary.procedures;

import net.minecraft.world.item.ItemStack;

public class PiercerToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getDamageValue() == 4) {
			itemstack.getOrCreateTag().putBoolean("needreload", true);
		} else if (itemstack.getDamageValue() == 0) {
			itemstack.getOrCreateTag().putBoolean("needreload", false);
		}
		if (itemstack.getOrCreateTag().getBoolean("needreload") == true) {
			if (itemstack.getOrCreateTag().getDouble("reloadpiercer") == 0) {
				itemstack.getOrCreateTag().putDouble("reloadpiercer", 80);
			} else {
				itemstack.getOrCreateTag().putDouble("reloadpiercer", (itemstack.getOrCreateTag().getDouble("reloadpiercer") - 1));
			}
			if (itemstack.getOrCreateTag().getDouble("reloadpiercer") == 0) {
				itemstack.setDamageValue((int) (itemstack.getDamageValue() + -1));
			}
		}
	}
}
