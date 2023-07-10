package io.github.feylostt.plagued.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.UUID;

public class GlaiveItem extends SwordItem {

	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

	public GlaiveItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float attackRange, Item.Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
		float attackDamage1 = (float) attackDamage + toolMaterial.getAttackDamage();
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(
			EntityAttributes.GENERIC_ATTACK_DAMAGE,
			new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", attackDamage1, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
			EntityAttributes.GENERIC_ATTACK_SPEED,
			new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION)
		);
		UUID ATTACK_RANGE_UUID = UUID.fromString("4bc91c24-58c2-4c73-bb45-7d34029ab9f0");
		builder.put(
			ReachEntityAttributes.ATTACK_RANGE,
			new EntityAttributeModifier(ATTACK_RANGE_UUID, "Weapon modifier", attackRange, EntityAttributeModifier.Operation.ADDITION)
		);
		this.attributeModifiers = builder.build();
	}

	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}
}
