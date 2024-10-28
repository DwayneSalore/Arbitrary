package net.mcreator.artbitrary.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HeightCheckProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		execute(null, world, x, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		boolean stop = false;
		if (entity.getPersistentData().getBoolean("CancelFall") == true) {
			if (entity.getPersistentData().getDouble("HeightCheckTime") == 0) {
				entity.getPersistentData().putDouble("HeightCheckTime", 20);
			} else {
				entity.getPersistentData().putDouble("HeightCheckTime", (entity.getPersistentData().getDouble("HeightCheckTime") - 1));
			}
			if (entity.getPersistentData().getDouble("HeightCheckTime") == 0) {
				if (entity.getPersistentData().getDouble("DistanceFromGround") == 0) {
					entity.getPersistentData().putDouble("DistanceFromGround", (entity.getY() - world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)));
				}
			}
		}
	}
}
