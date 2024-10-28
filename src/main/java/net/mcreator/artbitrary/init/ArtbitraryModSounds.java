
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ArtbitraryMod.MODID);
	public static final RegistryObject<SoundEvent> DASH = REGISTRY.register("dash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("artbitrary", "dash")));
	public static final RegistryObject<SoundEvent> TIMESTOP = REGISTRY.register("timestop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("artbitrary", "timestop")));
}
