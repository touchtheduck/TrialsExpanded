package dev.jaronline.trialsexpanded.data;

import dev.jaronline.trialsexpanded.ModItems;
import dev.jaronline.trialsexpanded.TrialsExpanded;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class Recipes extends RecipeProvider {
	public Recipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		addCraftingRecipes(recipeOutput);
	}

	private void addCraftingRecipes(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.VAULT)
				.define('E', Items.ENDER_CHEST)
				.define('K', Items.TRIAL_KEY)
				.define('B', Items.IRON_BARS)
				.define('S', Items.ECHO_SHARD)
				.define('C', Items.WIND_CHARGE)
				.pattern("KCK")
				.pattern("SES")
				.pattern("BBB")
				.unlockedBy(getHasName(Items.TRIAL_KEY), has(Items.TRIAL_KEY))
				.save(output, TrialsExpanded.asResource("vault"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIAL_SPAWNER)
				.define('B', Items.IRON_BARS)
				.define('W', Items.WITHER_SKELETON_SKULL)
				.define('S', Items.ECHO_SHARD)
				.define('L', Items.SOUL_LANTERN)
				.pattern("LBL")
				.pattern("SWS")
				.pattern("BBB")
				.unlockedBy(getHasName(Items.WITHER_SKELETON_SKULL), has(Items.WITHER_SKELETON_SKULL))
				.save(output, TrialsExpanded.asResource("trial_spawner"));

		copySmithingTemplate(output, ModItems.VAULT_UPGRADE_SMITHING_TEMPLATE, Items.OMINOUS_TRIAL_KEY);
	}
}
