package dev.jaronline.trialsexpanded.event;

import dev.jaronline.trialsexpanded.TrialsExpanded;
import dev.jaronline.trialsexpanded.util.ItemUtils;
import dev.jaronline.trialsexpanded.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VaultBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TrialSpawnerBlockEntity;
import net.minecraft.world.level.block.entity.trialspawner.TrialSpawner;
import net.minecraft.world.level.block.entity.trialspawner.TrialSpawnerData;
import net.minecraft.world.level.block.entity.vault.VaultBlockEntity;
import net.minecraft.world.level.block.entity.vault.VaultConfig;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Map;

@EventBusSubscriber(modid = TrialsExpanded.ID)
public class BlockEvents {
	@SubscribeEvent
	public static void onBreak(BlockEvent.BreakEvent event) {
		BlockState state = event.getState();
		Player player = event.getPlayer();

		if (state.is(Blocks.TRIAL_SPAWNER) && !player.isCreative()) {
			BlockPos pos = event.getPos();
			Level level = LevelUtils.getLevel(event.getLevel(), pos);
			BlockEntity blockEntity = level.getBlockEntity(pos);

			if (!(blockEntity instanceof TrialSpawnerBlockEntity spawnerBlockEntity)) {
				return;
			}

			TrialSpawner spawner = spawnerBlockEntity.getTrialSpawner();
			TrialSpawnerData data = spawner.getData();
			ItemStack item = Items.TRIAL_SPAWNER.getDefaultInstance();

			if (data.nextSpawnData.isPresent()) {
				CompoundTag blockEntityData = new CompoundTag();
				CompoundTag spawnData = new CompoundTag();
				spawnData.put(SpawnData.ENTITY_TAG, data.nextSpawnData.get().entityToSpawn());
				blockEntityData.put(TrialSpawnerData.TAG_SPAWN_DATA, spawnData);
				blockEntityData.putString("id", state.getBlockHolder().getRegisteredName());
				item.applyComponents(DataComponentMap.builder()
						.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(blockEntityData))
						.build());
			}

			state.getBlock().destroy(level, pos, state);
			ItemUtils.spawnItem(level, pos.getX(), pos.getY(), pos.getZ(), item);
		} else if (state.is(Blocks.VAULT) && !player.isCreative()) {
			BlockPos pos = event.getPos();
			Level level = LevelUtils.getLevel(event.getLevel(), pos);
			BlockEntity blockEntity = level.getBlockEntity(pos);

			if (!(blockEntity instanceof VaultBlockEntity vaultBlockEntity)) {
				return;
			}

			ItemStack item = Items.VAULT.getDefaultInstance();
			BlockItemStateProperties properties = new BlockItemStateProperties(Map.of(
					VaultBlock.OMINOUS.getName(), state.getValue(VaultBlock.OMINOUS).toString()
			));

			CompoundTag blockEntityData = new CompoundTag();
			blockEntityData.putString("id", state.getBlockHolder().getRegisteredName());
			blockEntityData.put(VaultConfig.TAG_NAME, VaultBlockEntity.encode(VaultConfig.CODEC, vaultBlockEntity.getConfig(), event.getLevel().registryAccess()));

			item.applyComponents(DataComponentMap.builder()
					.set(DataComponents.BLOCK_STATE, properties)
					.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(blockEntityData))
					.build());

			state.getBlock().destroy(level, pos, state);
			ItemUtils.spawnItem(level, pos.getX(), pos.getY(), pos.getZ(), item);
		}
	}

	private BlockEvents() {}
}
