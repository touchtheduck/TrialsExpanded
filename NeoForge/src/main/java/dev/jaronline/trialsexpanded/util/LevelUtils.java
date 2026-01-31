package dev.jaronline.trialsexpanded.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Objects;

public class LevelUtils {
	public static Level getLevel(LevelAccessor accessor, BlockPos pos) {
		if (accessor instanceof Level level) {
			return level;
		}
		BlockEntity entity = Objects.requireNonNull(accessor.getBlockEntity(pos));
		return Objects.requireNonNull(entity.getLevel());
	}

	private LevelUtils() {}
}
