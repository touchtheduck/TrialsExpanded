package dev.jaronline.trialsexpanded.data.lang;

import dev.jaronline.trialsexpanded.ModItems;
import dev.jaronline.trialsexpanded.ModLanguageKeys;
import dev.jaronline.trialsexpanded.TrialsExpanded;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnUsLanguageProvider extends LanguageProvider {
	public EnUsLanguageProvider(PackOutput output) {
		super(output, TrialsExpanded.ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		this.add(ModItems.VAULT_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
		this.add(ModLanguageKeys.VAULT_UPGRADE_APPLIES_TO, "Vault");
		this.add(ModLanguageKeys.VAULT_UPGRADE_INGREDIENTS, "Ominous Trial Key");
		this.add(ModLanguageKeys.VAULT_UPGRADE, "Vault Upgrade");
		this.add(ModLanguageKeys.VAULT_UPGRADE_BASE_SLOT, "Add Vault");
		this.add(ModLanguageKeys.VAULT_UPGRADE_ADDITIONS_SLOT, "Add Ominous Trial Key");
	}
}
