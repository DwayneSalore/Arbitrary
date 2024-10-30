
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.artbitrary.potion.ShakeMobEffect;
import net.mcreator.artbitrary.potion.AbruptMobEffect;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ArtbitraryMod.MODID);
	public static final RegistryObject<MobEffect> ABRUPT = REGISTRY.register("abrupt", () -> new AbruptMobEffect());
	public static final RegistryObject<MobEffect> SHAKE = REGISTRY.register("shake", () -> new ShakeMobEffect());
}
