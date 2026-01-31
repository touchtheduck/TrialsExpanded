package dev.jaronline.trialsexpanded.event;

import dev.jaronline.trialsexpanded.ModItems;
import dev.jaronline.trialsexpanded.ModLootModifiers;
import dev.jaronline.trialsexpanded.TrialsExpanded;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = TrialsExpanded.ID)
public class SetupEvents {
	@SubscribeEvent
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static void registerEntries(final RegisterEvent event) {
		if (event.getRegistryKey().equals(Registries.ITEM)) {
			ModItems.bootstrap();
		} else if (event.getRegistryKey().equals(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS)) {
			ModLootModifiers.bootstrap();
		}
	}

	private SetupEvents() {}
}
