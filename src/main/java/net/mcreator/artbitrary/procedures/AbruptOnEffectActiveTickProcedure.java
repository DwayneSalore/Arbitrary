package net.mcreator.artbitrary.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class AbruptOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double location = 0;
		entity.setNoGravity(true);
		if (entity instanceof Mob _entity)
			_entity.getNavigation().stop();
		entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
		{
			Entity _ent = entity;
			_ent.teleportTo((entity.getPersistentData().getDouble("locationX")), (entity.getPersistentData().getDouble("locationY")), (entity.getPersistentData().getDouble("locationZ")));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("locationX")), (entity.getPersistentData().getDouble("locationY")), (entity.getPersistentData().getDouble("locationZ")), _ent.getYRot(), _ent.getXRot());
		}
		{
			Entity _ent = entity;
			_ent.setYRot((float) entity.getPersistentData().getDouble("yawentity"));
			_ent.setXRot((float) entity.getPersistentData().getDouble("pitchentity"));
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
	}
}
