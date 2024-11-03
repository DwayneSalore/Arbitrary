package net.mcreator.artbitrary.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.artbitrary.init.ArtbitraryModBlockEntities;
import net.mcreator.artbitrary.block.renderer.IronLootboxTileRenderer;
import net.mcreator.artbitrary.ArtbitraryMod;

@Mod.EventBusSubscriber(modid = ArtbitraryMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ArtbitraryModBlockEntities.IRON_LOOTBOX.get(), context -> new IronLootboxTileRenderer());
	}
}
