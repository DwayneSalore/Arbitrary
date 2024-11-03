
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ArtbitraryMod.MODID);
	public static final RegistryObject<SimpleParticleType> SPACIAL_DIFFERENCE = REGISTRY.register("spacial_difference", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PURPLE = REGISTRY.register("purple", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PINK = REGISTRY.register("pink", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PURPLE_2 = REGISTRY.register("purple_2", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BLACK = REGISTRY.register("black", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WHITE = REGISTRY.register("white", () -> new SimpleParticleType(false));
}
