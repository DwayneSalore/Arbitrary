package net.mcreator.artbitrary.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;

public class ShakeOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake + 1;
			entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Shake = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake == 0) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 1));
				_ent.setXRot((float) (entity.getXRot() + 1));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		} else if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake == 1) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + -2));
				_ent.setXRot((float) (entity.getXRot() + -2));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		} else if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake == 2) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 1));
				_ent.setXRot((float) (entity.getXRot() + 1));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		} else if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake == 3) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 1));
				_ent.setXRot((float) (entity.getXRot() + -1));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		} else if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake == 4) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 0));
				_ent.setXRot((float) (entity.getXRot() + 1));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			{
				double _setval = 0;
				entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Shake = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).Shake > 4) {
			{
				double _setval = 0;
				entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Shake = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
