
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.artbitrary.item.EdibleIronIngotItem;
import net.mcreator.artbitrary.item.AncientPocketWatchItem;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ArtbitraryMod.MODID);
	public static final RegistryObject<Item> ANCIENT_POCKET_WATCH = REGISTRY.register("ancient_pocket_watch", () -> new AncientPocketWatchItem());
	public static final RegistryObject<Item> EDIBLE_IRON_INGOT = REGISTRY.register("edible_iron_ingot", () -> new EdibleIronIngotItem());
	// Start of user code block custom items
	// End of user code block custom items
}
