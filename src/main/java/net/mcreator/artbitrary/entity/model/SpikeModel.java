package net.mcreator.artbitrary.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.artbitrary.entity.SpikeEntity;

public class SpikeModel extends GeoModel<SpikeEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpikeEntity entity) {
		return new ResourceLocation("artbitrary", "animations/spike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpikeEntity entity) {
		return new ResourceLocation("artbitrary", "geo/spike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpikeEntity entity) {
		return new ResourceLocation("artbitrary", "textures/entities/" + entity.getTexture() + ".png");
	}

}
