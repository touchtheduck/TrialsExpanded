package dev.jaronline.trialsexpanded;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

public final class ModItems {
	public static final SmithingTemplateItem VAULT_UPGRADE_SMITHING_TEMPLATE = register(
			"vault_upgrade_smithing_template", new SmithingTemplateItem(
				Tooltips.VAULT_UPGRADE_APPLIES_TO,
				Tooltips.VAULT_UPGRADE_INGREDIENTS,
				Tooltips.VAULT_UPGRADE,
				Tooltips.VAULT_UPGRADE_BASE_SLOT,
				Tooltips.VAULT_UPGRADE_ADDITIONS_SLOT,
				ModGUITextures.VAULT_UPGRADE_BASE_SLOT_ICONS,
				ModGUITextures.VAULT_UPGRADE_ADDITIONS_SLOT_ICONS
			));

	@SuppressWarnings("UnusedReturnValue")
	public static Item bootstrap() {
		return VAULT_UPGRADE_SMITHING_TEMPLATE;
	}

	private static <I extends Item> I register(String identifier, I item) {
		return Registry.register(BuiltInRegistries.ITEM, TrialsExpanded.asResource(identifier), item);
	}

	private static final class Tooltips {
		private static final Component VAULT_UPGRADE_APPLIES_TO = Component.translatable(
				ModLanguageKeys.VAULT_UPGRADE_APPLIES_TO
		).withStyle(ChatFormatting.BLUE);
		private static final Component VAULT_UPGRADE_INGREDIENTS = Component.translatable(
				ModLanguageKeys.VAULT_UPGRADE_INGREDIENTS
		).withStyle(ChatFormatting.BLUE);
		private static final Component VAULT_UPGRADE = Component.translatable(
				ModLanguageKeys.VAULT_UPGRADE
		).withStyle(ChatFormatting.GRAY);
		private static final Component VAULT_UPGRADE_BASE_SLOT = Component.translatable(
				ModLanguageKeys.VAULT_UPGRADE_BASE_SLOT
		);
		private static final Component VAULT_UPGRADE_ADDITIONS_SLOT = Component.translatable(
				ModLanguageKeys.VAULT_UPGRADE_ADDITIONS_SLOT
		);
	}

	private ModItems() {}
}
