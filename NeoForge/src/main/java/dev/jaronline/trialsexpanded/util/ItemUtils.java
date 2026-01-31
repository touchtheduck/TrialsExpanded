package dev.jaronline.trialsexpanded.util;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemUtils {
	public static void spawnItem(Level level, int x, int y, int z, ItemStack item) {
		ItemEntity entity = new ItemEntity(level, x + 0.5, y + 0.5, z + 0.5, item);
		level.addFreshEntity(entity);
	}

	private ItemUtils() {}
}
