package io.github.feylostt.plagued.items;

import io.github.feylostt.plagued.Plagued;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class PlaguedItems {

	// Tools & Weapons
	public static Item NETHERITE_GLAIVE;

	// Armor
	// Materials
	// Block Items

	public static void init() {
		NETHERITE_GLAIVE = registerItem(new GlaiveItem(ToolMaterials.NETHERITE, 5, -3.0F, 1.0F, new QuiltItemSettings().fireproof()), "netherite_glaive");
	}

	private static Item registerItem(Item item, String name) {
		Registry.register(Registry.ITEM, new Identifier(Plagued.MODID, name), item);
		return item;
	}


}
