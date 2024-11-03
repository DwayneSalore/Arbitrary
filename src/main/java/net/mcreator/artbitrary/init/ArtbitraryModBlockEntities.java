
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.artbitrary.block.entity.IronLootboxTileEntity;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArtbitraryMod.MODID);
	public static final RegistryObject<BlockEntityType<IronLootboxTileEntity>> IRON_LOOTBOX = REGISTRY.register("iron_lootbox", () -> BlockEntityType.Builder.of(IronLootboxTileEntity::new, ArtbitraryModBlocks.IRON_LOOTBOX.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
