package net.mcreator.artbitrary.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.artbitrary.block.display.IronLootboxDisplayItem;

public class IronLootboxDisplayModel extends GeoModel<IronLootboxDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(IronLootboxDisplayItem animatable) {
		return new ResourceLocation("artbitrary", "animations/lootbox.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IronLootboxDisplayItem animatable) {
		return new ResourceLocation("artbitrary", "geo/lootbox.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IronLootboxDisplayItem entity) {
		return new ResourceLocation("artbitrary", "textures/block/lootbox_iron_texture.png");
	}
}
