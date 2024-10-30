package net.mcreator.artbitrary.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;
import net.mcreator.artbitrary.init.ArtbitraryModEntities;
import net.mcreator.artbitrary.entity.SpikeEntity;
import net.mcreator.artbitrary.ArtbitraryMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class SpikeActivationProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getXRot() >= 75 && entity.getXRot() <= 90) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Immunity != (entity
							.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Immunity) {
						if (!(entityiterator instanceof SpikeEntity)) {
							ArtbitraryMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ArtbitraryModEntities.SPIKE.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							});
						}
					}
				}
			}
		}
	}
}
