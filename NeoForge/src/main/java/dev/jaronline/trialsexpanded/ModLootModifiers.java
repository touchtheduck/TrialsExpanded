package dev.jaronline.trialsexpanded;

import com.mojang.serialization.MapCodec;
import dev.jaronline.trialsexpanded.loot.AddItemModifier;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModLootModifiers {
	public static final MapCodec<? extends IGlobalLootModifier> ADD_ITEM = register("add_item",
			AddItemModifier.CODEC);

	@SuppressWarnings("UnusedReturnValue")
	public static MapCodec<? extends IGlobalLootModifier> bootstrap() {
		return ADD_ITEM;
	}

	private static <M extends IGlobalLootModifier> MapCodec<M> register(String identifier, MapCodec<M> codec) {
		return Registry.register(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
				TrialsExpanded.asResource(identifier), codec);
	}

	private ModLootModifiers() {}
}
