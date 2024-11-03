package net.mcreator.artbitrary.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.artbitrary.block.model.IronLootboxBlockModel;
import net.mcreator.artbitrary.block.entity.IronLootboxTileEntity;

public class IronLootboxTileRenderer extends GeoBlockRenderer<IronLootboxTileEntity> {
	public IronLootboxTileRenderer() {
		super(new IronLootboxBlockModel());
	}

	@Override
	public RenderType getRenderType(IronLootboxTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
