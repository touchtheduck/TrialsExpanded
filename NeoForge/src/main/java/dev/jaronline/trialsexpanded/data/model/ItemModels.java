package dev.jaronline.trialsexpanded.data.model;

import dev.jaronline.trialsexpanded.ModItems;
import dev.jaronline.trialsexpanded.TrialsExpanded;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
	public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, TrialsExpanded.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		basicItem(ModItems.VAULT_UPGRADE_SMITHING_TEMPLATE);
	}
}
