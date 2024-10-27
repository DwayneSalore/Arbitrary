
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artbitrary.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.artbitrary.network.SecondAbilityMessage;
import net.mcreator.artbitrary.network.FirstAbilityMessage;
import net.mcreator.artbitrary.ArtbitraryMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ArtbitraryModKeyMappings {
	public static final KeyMapping FIRST_ABILITY = new KeyMapping("key.artbitrary.first_ability", GLFW.GLFW_KEY_Z, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ArtbitraryMod.PACKET_HANDLER.sendToServer(new FirstAbilityMessage(0, 0));
				FirstAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SECOND_ABILITY = new KeyMapping("key.artbitrary.second_ability", GLFW.GLFW_KEY_X, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ArtbitraryMod.PACKET_HANDLER.sendToServer(new SecondAbilityMessage(0, 0));
				SecondAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FIRST_ABILITY);
		event.register(SECOND_ABILITY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				FIRST_ABILITY.consumeClick();
				SECOND_ABILITY.consumeClick();
			}
		}
	}
}
