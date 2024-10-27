
package net.mcreator.artbitrary.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artbitrary.procedures.AbruptOnEffectActiveTickProcedure;
import net.mcreator.artbitrary.procedures.AbruptEffectStartedappliedProcedure;
import net.mcreator.artbitrary.procedures.AbruptEffectExpiresProcedure;

import java.util.List;
import java.util.ArrayList;

public class AbruptMobEffect extends MobEffect {
	public AbruptMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16737895);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
		return cures;
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AbruptEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AbruptOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AbruptEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
