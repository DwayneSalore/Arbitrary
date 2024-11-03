package net.mcreator.artbitrary.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.artbitrary.block.entity.IronLootboxTileEntity;

public class IronLootboxBlockModel extends GeoModel<IronLootboxTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(IronLootboxTileEntity animatable) {
		return new ResourceLocation("artbitrary", "animations/lootbox.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IronLootboxTileEntity animatable) {
		return new ResourceLocation("artbitrary", "geo/lootbox.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IronLootboxTileEntity animatable) {
		return new ResourceLocation("artbitrary", "textures/block/lootbox_iron_texture.png");
	}
}
