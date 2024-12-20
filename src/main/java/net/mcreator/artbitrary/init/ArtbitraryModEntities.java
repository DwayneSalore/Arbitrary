
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.entity.SpikeEntity;
import net.mcreator.artbitrary.entity.PiercingLightEntity;
import net.mcreator.artbitrary.entity.Irontemp2Entity;
import net.mcreator.artbitrary.entity.DistortionEntity;
import net.mcreator.artbitrary.entity.BlueFireEntity;
import net.mcreator.artbitrary.ArtbitraryMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArtbitraryModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArtbitraryMod.MODID);
	public static final RegistryObject<EntityType<Irontemp2Entity>> IRONTEMP_2 = register("irontemp_2",
			EntityType.Builder.<Irontemp2Entity>of(Irontemp2Entity::new, MobCategory.MISC).setCustomClientFactory(Irontemp2Entity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SpikeEntity>> SPIKE = register("spike",
			EntityType.Builder.<SpikeEntity>of(SpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpikeEntity::new).fireImmune().sized(1f, 1.8f));
	public static final RegistryObject<EntityType<DistortionEntity>> DISTORTION = register("distortion",
			EntityType.Builder.<DistortionEntity>of(DistortionEntity::new, MobCategory.MISC).setCustomClientFactory(DistortionEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PiercingLightEntity>> PIERCING_LIGHT = register("piercing_light",
			EntityType.Builder.<PiercingLightEntity>of(PiercingLightEntity::new, MobCategory.MISC).setCustomClientFactory(PiercingLightEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlueFireEntity>> BLUE_FIRE = register("blue_fire",
			EntityType.Builder.<BlueFireEntity>of(BlueFireEntity::new, MobCategory.MISC).setCustomClientFactory(BlueFireEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SpikeEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SPIKE.get(), SpikeEntity.createAttributes().build());
	}
}
