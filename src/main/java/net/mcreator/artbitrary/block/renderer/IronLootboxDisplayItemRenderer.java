package net.mcreator.artbitrary.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.artbitrary.block.model.IronLootboxDisplayModel;
import net.mcreator.artbitrary.block.display.IronLootboxDisplayItem;

public class IronLootboxDisplayItemRenderer extends GeoItemRenderer<IronLootboxDisplayItem> {
	public IronLootboxDisplayItemRenderer() {
		super(new IronLootboxDisplayModel());
	}

	@Override
	public RenderType getRenderType(IronLootboxDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
