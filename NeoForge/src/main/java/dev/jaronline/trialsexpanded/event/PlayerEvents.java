package dev.jaronline.trialsexpanded.event;

import dev.jaronline.trialsexpanded.TrialsExpanded;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VaultBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.vault.VaultBlockEntity;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.UUID;

@EventBusSubscriber(modid = TrialsExpanded.ID)
public class PlayerEvents {
	@SubscribeEvent
	public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
		if (event.getState().is(Blocks.VAULT) || event.getState().is(Blocks.TRIAL_SPAWNER)) {
			event.setNewSpeed(event.getOriginalSpeed() * 25f);
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
		Level level = event.getLevel();

		if (level.isClientSide()) return;

		BlockPos pos = event.getPos();

		if (!(level.getBlockState(pos).getBlock() instanceof VaultBlock)) return;

		ServerLevel serverLevel = (ServerLevel) level;
		MinecraftServer server = serverLevel.getServer();
		UUID playerId = event.getEntity().getUUID();

		server.tell(new TickTask(server.getTickCount() + 1, () -> {
			BlockEntity blockEntity = serverLevel.getBlockEntity(pos);

			if (!(blockEntity instanceof VaultBlockEntity vault)) return;

			VaultServerData vaultData = vault.getServerData();

			if (vaultData == null) return;

			vaultData.getRewardedPlayers().remove(playerId);
			vaultData.markChanged();
			vault.setChanged();
		}));
	}

	private PlayerEvents() {}
}
