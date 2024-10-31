package net.mcreator.artbitrary.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artbitrary.network.ArtbitraryModVariables;
import net.mcreator.artbitrary.init.ArtbitraryModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StaminaEatProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(ArtbitraryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ArtbitraryModVariables.PlayerVariables())).PhysicalAttunement == true) {
			if (itemstack.getItem().isEdible()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ArtbitraryModMobEffects.STAMINA_REGEN.get(),
							(int) (500 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArtbitraryModMobEffects.STAMINA_REGEN.get()) ? _livEnt.getEffect(ArtbitraryModMobEffects.STAMINA_REGEN.get()).getDuration() : 0)), 0, false,
							false));
			}
		}
	}
}
