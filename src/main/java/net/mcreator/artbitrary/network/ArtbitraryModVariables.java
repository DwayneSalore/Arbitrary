package net.mcreator.artbitrary.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.artbitrary.ArtbitraryMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArtbitraryModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ArtbitraryMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Immunity = original.Immunity;
			clone.immunity = original.immunity;
			clone.locationX = original.locationX;
			clone.locationY = original.locationY;
			clone.locationZ = original.locationZ;
			clone.PhysicalAttunement = original.PhysicalAttunement;
			if (!event.isWasDeath()) {
				clone.ironman = original.ironman;
				clone.IronLevel = original.IronLevel;
				clone.IronResistance = original.IronResistance;
				clone.IronLevelOverlay = original.IronLevelOverlay;
				clone.IronResistanceOverlay = original.IronResistanceOverlay;
				clone.Shake = original.Shake;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("artbitrary", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Immunity = 0;
		public boolean immunity = false;
		public double locationX = 0;
		public double locationY = 0;
		public double locationZ = 0;
		public boolean ironman = false;
		public double IronLevel = 0;
		public double IronResistance = 0;
		public String IronLevelOverlay = "\"\"";
		public String IronResistanceOverlay = "\"\"";
		public boolean PhysicalAttunement = false;
		public double Shake = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ArtbitraryMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Immunity", Immunity);
			nbt.putBoolean("immunity", immunity);
			nbt.putDouble("locationX", locationX);
			nbt.putDouble("locationY", locationY);
			nbt.putDouble("locationZ", locationZ);
			nbt.putBoolean("ironman", ironman);
			nbt.putDouble("IronLevel", IronLevel);
			nbt.putDouble("IronResistance", IronResistance);
			nbt.putString("IronLevelOverlay", IronLevelOverlay);
			nbt.putString("IronResistanceOverlay", IronResistanceOverlay);
			nbt.putBoolean("PhysicalAttunement", PhysicalAttunement);
			nbt.putDouble("Shake", Shake);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			Immunity = nbt.getDouble("Immunity");
			immunity = nbt.getBoolean("immunity");
			locationX = nbt.getDouble("locationX");
			locationY = nbt.getDouble("locationY");
			locationZ = nbt.getDouble("locationZ");
			ironman = nbt.getBoolean("ironman");
			IronLevel = nbt.getDouble("IronLevel");
			IronResistance = nbt.getDouble("IronResistance");
			IronLevelOverlay = nbt.getString("IronLevelOverlay");
			IronResistanceOverlay = nbt.getString("IronResistanceOverlay");
			PhysicalAttunement = nbt.getBoolean("PhysicalAttunement");
			Shake = nbt.getDouble("Shake");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Immunity = message.data.Immunity;
					variables.immunity = message.data.immunity;
					variables.locationX = message.data.locationX;
					variables.locationY = message.data.locationY;
					variables.locationZ = message.data.locationZ;
					variables.ironman = message.data.ironman;
					variables.IronLevel = message.data.IronLevel;
					variables.IronResistance = message.data.IronResistance;
					variables.IronLevelOverlay = message.data.IronLevelOverlay;
					variables.IronResistanceOverlay = message.data.IronResistanceOverlay;
					variables.PhysicalAttunement = message.data.PhysicalAttunement;
					variables.Shake = message.data.Shake;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
