package net.mcreator.artbitrary.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;
import net.mcreator.artbitrary.init.ArtbitraryModEntities;
import net.mcreator.artbitrary.entity.Irontemp2Entity;
import net.mcreator.artbitrary.ArtbitraryMod;

public class ShrapnelExplosionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).ironman == true) {
			if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).IronLevel >= 5) {
				{
					double _setval = (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).IronLevel - 5;
					entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IronLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null,
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), 2,
							Level.ExplosionInteraction.MOB);
				for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 15, 40); index0++) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback) {
								AbstractArrow entityToSpawn = new Irontemp2Entity(ArtbitraryModEntities.IRONTEMP_2.get(), level);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setCritArrow(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 0, 1);
						_entityToSpawn.setPos(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 0.5, 3)), (Mth.nextDouble(RandomSource.create(), 0.5, 2)), (Mth.nextDouble(RandomSource.create(), 0.5, 3)), (float) Mth.nextDouble(RandomSource.create(), 0.3, 0.7),
								120);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				ArtbitraryMod.queueServerWork(10, () -> {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), 2,
								Level.ExplosionInteraction.MOB);
					for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), 15, 40); index1++) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new Irontemp2Entity(ArtbitraryModEntities.IRONTEMP_2.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setCritArrow(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 0.5, 3)), (Mth.nextDouble(RandomSource.create(), 0.5, 2)), (Mth.nextDouble(RandomSource.create(), 0.5, 3)),
									(float) Mth.nextDouble(RandomSource.create(), 0.3, 0.7), 120);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					ArtbitraryMod.queueServerWork(10, () -> {
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null,
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									2, Level.ExplosionInteraction.MOB);
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new Irontemp2Entity(ArtbitraryModEntities.IRONTEMP_2.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setCritArrow(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 0.5, 3)), (Mth.nextDouble(RandomSource.create(), 0.5, 2)), (Mth.nextDouble(RandomSource.create(), 0.5, 3)),
									(float) Mth.nextDouble(RandomSource.create(), 0.3, 0.7), 120);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						ArtbitraryMod.queueServerWork(10, () -> {
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null,
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(11)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(11)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(11)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()),
										2, Level.ExplosionInteraction.MOB);
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, float damage, int knockback) {
										AbstractArrow entityToSpawn = new Irontemp2Entity(ArtbitraryModEntities.IRONTEMP_2.get(), level);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setCritArrow(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, 0, 1);
								_entityToSpawn.setPos(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(11)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(11)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(11)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 0.5, 3)), (Mth.nextDouble(RandomSource.create(), 0.5, 2)), (Mth.nextDouble(RandomSource.create(), 0.5, 3)),
										(float) Mth.nextDouble(RandomSource.create(), 0.3, 0.7), 120);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							ArtbitraryMod.queueServerWork(10, () -> {
								if (world instanceof Level _level && !_level.isClientSide())
									_level.explode(null,
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(13)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(13)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(13)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()),
											2, Level.ExplosionInteraction.MOB);
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, float damage, int knockback) {
											AbstractArrow entityToSpawn = new Irontemp2Entity(ArtbitraryModEntities.IRONTEMP_2.get(), level);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											entityToSpawn.setCritArrow(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, 0, 1);
									_entityToSpawn.setPos(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(13)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(13)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(13)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 0.5, 3)), (Mth.nextDouble(RandomSource.create(), 0.5, 2)), (Mth.nextDouble(RandomSource.create(), 0.5, 3)),
											(float) Mth.nextDouble(RandomSource.create(), 0.3, 0.7), 120);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							});
						});
					});
				});
			}
		}
	}
}
