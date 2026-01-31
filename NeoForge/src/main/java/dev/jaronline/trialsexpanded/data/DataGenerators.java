package dev.jaronline.trialsexpanded.data;

import dev.jaronline.trialsexpanded.TrialsExpanded;
import dev.jaronline.trialsexpanded.data.lang.EnUsLanguageProvider;
import dev.jaronline.trialsexpanded.data.model.ItemModels;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = TrialsExpanded.ID)
public class DataGenerators {
	@SubscribeEvent
	public static void onGatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(event.includeServer(), new Recipes(output, lookupProvider));
		generator.addProvider(event.includeServer(), new GlobalLootModifiers(output, lookupProvider));

		generator.addProvider(event.includeClient(), new EnUsLanguageProvider(output));
		generator.addProvider(event.includeClient(), new ItemModels(output, existingFileHelper));
	}

	private DataGenerators() {}
}
