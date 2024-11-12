
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.artbitrary.potion.VulnerabilityMobEffect;
import net.mcreator.artbitrary.potion.StaminaRegenMobEffect;
import net.mcreator.artbitrary.potion.ShakeMobEffect;
import net.mcreator.artbitrary.potion.PiercedMobEffect;
import net.mcreator.artbitrary.potion.AbruptMobEffect;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ArtbitraryModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ArtbitraryMod.MODID);
	public static final RegistryObject<MobEffect> ABRUPT = REGISTRY.register("abrupt", () -> new AbruptMobEffect());
	public static final RegistryObject<MobEffect> SHAKE = REGISTRY.register("shake", () -> new ShakeMobEffect());
	public static final RegistryObject<MobEffect> STAMINA_REGEN = REGISTRY.register("stamina_regen", () -> new StaminaRegenMobEffect());
	public static final RegistryObject<MobEffect> PIERCED = REGISTRY.register("pierced", () -> new PiercedMobEffect());
	public static final RegistryObject<MobEffect> VULNERABILITY = REGISTRY.register("vulnerability", () -> new VulnerabilityMobEffect());
}
