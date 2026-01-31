package dev.jaronline.trialsexpanded;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;

@Mod(TrialsExpanded.ID)
@SuppressWarnings("java:S1118")
public class TrialsExpanded {
	public static final String ID = "trialsexpanded";

	public static ResourceLocation asResource(String path) {
		return ResourceLocation.fromNamespaceAndPath(ID, path);
	}
}
