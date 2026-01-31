package dev.jaronline.trialsexpanded.data;

import dev.jaronline.trialsexpanded.ModItems;
import dev.jaronline.trialsexpanded.TrialsExpanded;
import dev.jaronline.trialsexpanded.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.AllOfCondition;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class GlobalLootModifiers extends GlobalLootModifierProvider {
	public GlobalLootModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, TrialsExpanded.ID);
	}

	@Override
	protected void start() {
		this.add("vault_upgrade_to_trial_chambers_reward", new AddItemModifier(
				new LootItemCondition[]{
						AnyOfCondition.anyOf(
								AllOfCondition.allOf(
										LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace(
												"chests/trial_chambers/reward")),
										LootItemRandomChanceCondition.randomChance(0.1f)
								),
								AllOfCondition.allOf(
										LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace(
												"chests/trial_chambers/reward_ominous")),
										LootItemRandomChanceCondition.randomChance(0.25f)
								)
						).build()
				},
				ModItems.VAULT_UPGRADE_SMITHING_TEMPLATE
		));
	}
}
