
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.artbitrary.client.renderer.SpikeRenderer;
import net.mcreator.artbitrary.client.renderer.PiercingLightRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ArtbitraryModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ArtbitraryModEntities.IRONTEMP_2.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ArtbitraryModEntities.SPIKE.get(), SpikeRenderer::new);
		event.registerEntityRenderer(ArtbitraryModEntities.DISTORTION.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ArtbitraryModEntities.PIERCING_LIGHT.get(), PiercingLightRenderer::new);
		event.registerEntityRenderer(ArtbitraryModEntities.BLUE_FIRE.get(), ThrownItemRenderer::new);
	}
}
