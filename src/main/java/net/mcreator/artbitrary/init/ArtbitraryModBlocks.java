
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.artbitrary.block.IronLootboxBlock;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ArtbitraryMod.MODID);
	public static final RegistryObject<Block> IRON_LOOTBOX = REGISTRY.register("iron_lootbox", () -> new IronLootboxBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
