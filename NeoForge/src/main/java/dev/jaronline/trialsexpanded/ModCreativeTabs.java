package dev.jaronline.trialsexpanded;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = TrialsExpanded.ID)
public final class ModCreativeTabs {
	@SubscribeEvent
	public static void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.VAULT_UPGRADE_SMITHING_TEMPLATE);
		}
	}

	private ModCreativeTabs() {}
}
