
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.artbitrary.ArtbitraryMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArtbitraryModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArtbitraryMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(ArtbitraryModItems.ANCIENT_POCKET_WATCH.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(ArtbitraryModItems.SPIKE_SPAWN_EGG.get());

		}
	}
}
