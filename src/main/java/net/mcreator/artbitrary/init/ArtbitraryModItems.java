
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.artbitrary.item.SpaceCutterItem;
import net.mcreator.artbitrary.item.EdibleIronIngotItem;
import net.mcreator.artbitrary.item.AncientPocketWatchItem;
import net.mcreator.artbitrary.block.display.IronLootboxDisplayItem;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ArtbitraryMod.MODID);
	public static final RegistryObject<Item> ANCIENT_POCKET_WATCH = REGISTRY.register("ancient_pocket_watch", () -> new AncientPocketWatchItem());
	public static final RegistryObject<Item> EDIBLE_IRON_INGOT = REGISTRY.register("edible_iron_ingot", () -> new EdibleIronIngotItem());
	public static final RegistryObject<Item> SPIKE_SPAWN_EGG = REGISTRY.register("spike_spawn_egg", () -> new ForgeSpawnEggItem(ArtbitraryModEntities.SPIKE, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> IRON_LOOTBOX = REGISTRY.register(ArtbitraryModBlocks.IRON_LOOTBOX.getId().getPath(), () -> new IronLootboxDisplayItem(ArtbitraryModBlocks.IRON_LOOTBOX.get(), new Item.Properties()));
	public static final RegistryObject<Item> SPACE_CUTTER = REGISTRY.register("space_cutter", () -> new SpaceCutterItem());
	// Start of user code block custom items
	// End of user code block custom items
}
