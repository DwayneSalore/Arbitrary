
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.artbitrary.client.particle.WhiteParticle;
import net.mcreator.artbitrary.client.particle.SpacialDifferenceParticle;
import net.mcreator.artbitrary.client.particle.PurpleParticle;
import net.mcreator.artbitrary.client.particle.Purple2Particle;
import net.mcreator.artbitrary.client.particle.PinkParticle;
import net.mcreator.artbitrary.client.particle.BlackParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ArtbitraryModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ArtbitraryModParticleTypes.SPACIAL_DIFFERENCE.get(), SpacialDifferenceParticle::provider);
		event.registerSpriteSet(ArtbitraryModParticleTypes.PURPLE.get(), PurpleParticle::provider);
		event.registerSpriteSet(ArtbitraryModParticleTypes.PINK.get(), PinkParticle::provider);
		event.registerSpriteSet(ArtbitraryModParticleTypes.PURPLE_2.get(), Purple2Particle::provider);
		event.registerSpriteSet(ArtbitraryModParticleTypes.BLACK.get(), BlackParticle::provider);
		event.registerSpriteSet(ArtbitraryModParticleTypes.WHITE.get(), WhiteParticle::provider);
	}
}
