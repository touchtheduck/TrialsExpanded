package dev.jaronline.trialsexpanded;

import net.minecraft.resources.ResourceLocation;

public final class ModLanguageKeys {
	private static final ResourceLocation VAULT_UPGRADE_SMITHING_TEMPLATE = TrialsExpanded.asResource("smithing_template.vault_upgrade");

	public static final String VAULT_UPGRADE_APPLIES_TO = item(VAULT_UPGRADE_SMITHING_TEMPLATE, "applies_to");
	public static final String VAULT_UPGRADE_INGREDIENTS = item(VAULT_UPGRADE_SMITHING_TEMPLATE, "ingredients");
	public static final String VAULT_UPGRADE = TrialsExpanded.asResource("vault_upgrade").toLanguageKey("upgrade");
	public static final String VAULT_UPGRADE_BASE_SLOT = item(VAULT_UPGRADE_SMITHING_TEMPLATE, "base_slot_description");
	public static final String VAULT_UPGRADE_ADDITIONS_SLOT = item(VAULT_UPGRADE_SMITHING_TEMPLATE, "additions_slot_description");

	private static String item(ResourceLocation id, String key) {
		return id.toLanguageKey("item", key);
	}

	private ModLanguageKeys() {}
}
