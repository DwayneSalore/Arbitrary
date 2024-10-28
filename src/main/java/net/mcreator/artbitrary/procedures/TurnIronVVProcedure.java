package net.mcreator.artbitrary.procedures;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;
import net.mcreator.artbitrary.ArtbitraryMod;

import javax.annotation.Nullable;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class TurnIronVVProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		ArtbitraryMod.PACKET_HANDLER.sendToServer(new TurnIronVVMessage());
		execute(event.getEntity());
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TurnIronVVMessage {
		public TurnIronVVMessage() {
		}

		public TurnIronVVMessage(FriendlyByteBuf buffer) {
		}

		public static void buffer(TurnIronVVMessage message, FriendlyByteBuf buffer) {
		}

		public static void handler(TurnIronVVMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getSender().level().hasChunkAt(context.getSender().blockPosition()))
					return;
				execute(context.getSender());
			});
			context.setPacketHandled(true);
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			ArtbitraryMod.addNetworkMessage(TurnIronVVMessage.class, TurnIronVVMessage::buffer, TurnIronVVMessage::new, TurnIronVVMessage::handler);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double diamonds = 0;
		double iron = 0;
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).ironman == true) {
			if (entity.isShiftKeyDown()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 9) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.IRON_INGOT);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 9, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(Blocks.IRON_BLOCK).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.IRON_BLOCK.asItem()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.IRON_BLOCK);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
						_setstack.setCount(9);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
