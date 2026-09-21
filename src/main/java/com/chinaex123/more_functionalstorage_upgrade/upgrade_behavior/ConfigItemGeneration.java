package com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior;

import com.buuz135.functionalstorage.block.tile.ControllableDrawerTile;
import com.buuz135.functionalstorage.item.component.FunctionalUpgradeBehavior;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;

import java.util.List;

/**
 * 物品生成升级行为
 * <p>
 * 实现 FunctionalUpgradeBehavior，为功能性存储的抽屉提供物品生成能力。
 * 按配置的间隔时间，向抽屉本身或相邻容器插入指定物品。
 * 通过记录类（record）持有物品、每次生成量与生成间隔三项配置。
 *
 * @param item         要生成的物品
 * @param amountPerTick 每次生成的物品数量
 * @param interval     生成间隔（tick）
 */
public record ConfigItemGeneration(ItemStack item, int amountPerTick, int interval) implements FunctionalUpgradeBehavior {

    /** 升级行为的编解码器，定义各配置字段的序列化方式 */
    public static final MapCodec<ConfigItemGeneration> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ItemStack.CODEC.fieldOf("item").forGetter(ConfigItemGeneration::item),
                    Codec.INT.fieldOf("amountPerTick").orElse(1).forGetter(ConfigItemGeneration::amountPerTick),
                    Codec.INT.fieldOf("interval").orElse(20).forGetter(ConfigItemGeneration::interval)
            ).apply(instance, ConfigItemGeneration::new));

    /**
     * 执行物品生成逻辑。
     * <p>
     * 此方法负责在指定间隔时间内生成物品，并将其插入到合适的容器中。
     * 优先插入抽屉本身，其次检查上方容器，最后检查周围其他方向的容器。
     *
     * @param level        游戏世界对象
     * @param pos          抽屉方块的位置
     * @param drawer       可控制的抽屉方块实体
     * @param upgradeStack 升级物品堆栈
     * @param upgradeSlot  升级槽位索引
     */
    @Override
    public void work(Level level, BlockPos pos, ControllableDrawerTile<?> drawer,
                     ItemStack upgradeStack, int upgradeSlot) {
        // 只在服务器端工作，并且按间隔执行
        if (level.isClientSide() || level.getGameTime() % interval != 0) {
            return;
        }

        // 准备要生成的物品堆栈
        ItemStack itemToGenerate = item.copy();
        if (amountPerTick > 1 && itemToGenerate.getMaxStackSize() > 1) {
            itemToGenerate.setCount(Math.min(amountPerTick, itemToGenerate.getMaxStackSize()));
        }

        // 首先检查抽屉本身是否有物品处理能力
        var drawerCapability = level.getCapability(Capabilities.Item.BLOCK, pos, null);
        if (drawerCapability != null) {
            try (var tx = Transaction.openRoot()) {
                drawerCapability.insert(ItemResource.of(itemToGenerate), itemToGenerate.getCount(), tx);
                tx.commit();
            }
            return;
        }

        // 否则检查上方的方块
        var aboveCapability = level.getCapability(Capabilities.Item.BLOCK, pos, Direction.UP);
        if (aboveCapability != null) {
            try (var tx = Transaction.openRoot()) {
                aboveCapability.insert(ItemResource.of(itemToGenerate), itemToGenerate.getCount(), tx);
                tx.commit();
            }
            return;
        }

        // 检查其他方向
        for (Direction direction : Direction.values()) {
            if (direction == Direction.UP) continue;

            var sideCapability = level.getCapability(Capabilities.Item.BLOCK,
                    pos.relative(direction), direction.getOpposite());
            if (sideCapability != null) {
                try (var tx = Transaction.openRoot()) {
                    sideCapability.insert(ItemResource.of(itemToGenerate), itemToGenerate.getCount(), tx);
                    tx.commit();
                }
                break;
            }
        }
    }

    /**
     * 获取该升级行为的编解码器。
     *
     * @return 升级行为的编解码器
     */
    @Override
    public MapCodec<? extends FunctionalUpgradeBehavior> codec() {
        return CODEC;
    }

    /**
     * 获取物品生成升级的工具提示信息。
     * <p>
     * 此方法扩展了父类的工具提示功能，添加了特定于物品生成的信息，
     * 显示每次生成的物品数量和物品名称。
     *
     * @return 包含工具提示信息的组件列表
     */
    @Override
    public List<Component> getTooltip() {
        var list = FunctionalUpgradeBehavior.super.getTooltip();
        list.add(Component.translatable("moreupgrade.desc.item_generation",
                amountPerTick,
                item.getHoverName().getString()));
        return list;
    }

    /**
     * 延迟配置物品生成类 - 解决模组间注册时机冲突问题。
     * <p>
     * 这个类专门处理与 Sodium 等模组的兼容性问题。主要特点：
     * 1. 延迟物品获取：不在注册时获取物品引用，而是在实际生成时动态获取；
     * 2. 注册时机安全：避免在模组加载早期阶段访问未完全注册的物品；
     * 3. 容错机制：当物品无法找到时返回默认物品而非 AIR。
     */
    public record Delayed(String itemId, int amountPerTick, int interval) implements FunctionalUpgradeBehavior {

        /**
         * 执行物品生成逻辑（延迟获取物品版本）。
         * <p>
         * 与父类逻辑一致，但物品引用在运行时才通过 ID 获取，
         * 以确保物品已完成注册。
         *
         * @param level        游戏世界对象
         * @param pos          抽屉方块的位置
         * @param drawer       可控制的抽屉方块实体
         * @param upgradeStack 升级物品堆栈
         * @param upgradeSlot  升级槽位索引
         */
        @Override
        public void work(Level level, BlockPos pos, ControllableDrawerTile<?> drawer, ItemStack upgradeStack, int upgradeSlot) {
            // 只在服务器端按指定间隔工作
            if (level.isClientSide() || level.getGameTime() % interval != 0) {
                return;
            }

            // 核心：延迟获取物品，确保在使用时物品已完全注册
            ItemStack itemToGenerate = getItem(itemId, Math.min(amountPerTick, 64));

            // 复用原有的物品插入逻辑
            var drawerCapability = level.getCapability(Capabilities.Item.BLOCK, pos, null);
            if (drawerCapability != null) {
                try (var tx = Transaction.openRoot()) {
                    drawerCapability.insert(ItemResource.of(itemToGenerate), itemToGenerate.getCount(), tx);
                    tx.commit();
                }
                return;
            }

            var aboveCapability = level.getCapability(Capabilities.Item.BLOCK, pos, Direction.UP);
            if (aboveCapability != null) {
                try (var tx = Transaction.openRoot()) {
                    aboveCapability.insert(ItemResource.of(itemToGenerate), itemToGenerate.getCount(), tx);
                    tx.commit();
                }
                return;
            }

            // 检查其他方向的容器
            for (Direction direction : Direction.values()) {
                if (direction == Direction.UP) continue;

                var sideCapability = level.getCapability(Capabilities.Item.BLOCK,
                        pos.relative(direction), direction.getOpposite());
                if (sideCapability != null) {
                    try (var tx = Transaction.openRoot()) {
                        sideCapability.insert(ItemResource.of(itemToGenerate), itemToGenerate.getCount(), tx);
                        tx.commit();
                    }
                    break;
                }
            }
        }

        /**
         * 延迟获取物品 - 解决注册时机问题的核心方法。
         *
         * @param itemId 物品 ID
         * @param count  数量
         * @return 物品堆栈
         */
        private ItemStack getItem(String itemId, int count) {
            // 在实际使用时才获取物品引用，确保物品已注册完成
            Item item = BuiltInRegistries.ITEM.get(Identifier.parse(itemId))
                    .map(Holder.Reference::value)
                    .orElse(Items.AIR);
            if (item == Items.AIR) {
                // 容错处理：返回默认物品而不是 AIR，避免生成失败
                return new ItemStack(Items.COBBLESTONE, count);
            }
            return new ItemStack(item, count);
        }

        /**
         * 获取该升级行为的编解码器。
         *
         * @return 升级行为的编解码器
         */
        @Override
        public MapCodec<? extends FunctionalUpgradeBehavior> codec() {
            // 用于序列化的 codec 配置
            return RecordCodecBuilder.<Delayed>mapCodec(instance -> instance.group(
                    Codec.STRING.fieldOf("itemId").forGetter(Delayed::itemId),
                    Codec.INT.fieldOf("amountPerTick").forGetter(Delayed::amountPerTick),
                    Codec.INT.fieldOf("interval").forGetter(Delayed::interval)
            ).apply(instance, Delayed::new));
        }

        /**
         * 获取物品生成升级的工具提示信息（延迟获取物品版本）。
         *
         * @return 包含工具提示信息的组件列表
         */
        @Override
        public List<Component> getTooltip() {
            // 动态获取物品用于 tooltip 显示
            Item item = BuiltInRegistries.ITEM.get(Identifier.parse(itemId))
                    .map(Holder.Reference::value)
                    .orElse(Items.AIR);
            var list = FunctionalUpgradeBehavior.super.getTooltip();
            list.add(Component.translatable("moreupgrade.desc.item_generation",
                    amountPerTick,
                    item.getDefaultInstance().getHoverName().getString()));
            return list;
        }
    }
}