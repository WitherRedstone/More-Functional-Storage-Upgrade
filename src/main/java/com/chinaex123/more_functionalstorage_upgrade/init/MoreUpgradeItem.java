package com.chinaex123.more_functionalstorage_upgrade.init;

import com.buuz135.functionalstorage.item.UpgradeItem;
import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.component.SizeProvider;
import com.buuz135.functionalstorage.block.config.FunctionalStorageConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.ARGB;
import org.jetbrains.annotations.NotNull;

/**
 * 更多升级物品
 * <p>
 * 继承自功能性存储的 UpgradeItem，作为存储类型升级使用。
 * 根据升级类型应用物品、流体与控制器范围三项容量倍率修改器，
 * 并自定义物品名称颜色与附魔光效。
 */
public class MoreUpgradeItem extends UpgradeItem {

    /**
     * 升级类型枚举。
     * <p>
     * 定义各类存储升级的容量倍率、名称颜色与附魔光效。
     */
    public enum UpgradeType {

        // 鳞甲升级
        TURTLE_SCUTE_UPGRADE("turtle_scute_upgrade", 48.0f, ARGB.color(0, 255, 255), false),
        // 下界之星升级
        NETHER_STAR_UPGRADE("nether_star_upgrade", 72.0f, ARGB.color(255, 215, 0), false),
        // 重锤升级
        HEAVY_CORE_UPGRADE("heavy_core_upgrade", 128.0f, ARGB.color(153, 50, 204), false);

        /** 升级类型的名称 */
        private final String name;
        /** 容量倍率 */
        private final float multiplier;
        /** 物品名称颜色 */
        private final int color;
        /** 是否具有闪烁效果 */
        private final boolean hasGlint;

        /**
         * 构造升级类型。
         *
         * @param name       升级类型名称
         * @param multiplier 容量倍率
         * @param color      物品名称颜色
         * @param hasGlint   是否具有闪烁效果
         */
        UpgradeType(String name, float multiplier, int color, boolean hasGlint) {
            this.name = name;
            this.multiplier = multiplier;
            this.color = color;
            this.hasGlint = hasGlint;
        }

        /**
         * 获取升级类型名称。
         *
         * @return 升级类型名称
         */
        public String getName() {
            return name;
        }

        /**
         * 获取容量倍率。
         *
         * @return 容量倍率
         */
        public float getMultiplier() {
            return multiplier;
        }

        /**
         * 获取物品名称颜色。
         *
         * @return 物品名称颜色
         */
        public int getColor() {
            return color;
        }

        /**
         * 判断是否具有闪烁效果。
         *
         * @return 具有闪烁效果返回 true
         */
        public boolean hasGlint() {
            return hasGlint;
        }
    }

    /** 当前物品实例的升级类型 */
    private final UpgradeType type;

    /**
     * 构造更多升级物品。
     * <p>
     * 根据升级类型设置物品、流体与控制器范围三项容量倍率修改器，
     * 并标记为存储类型升级。
     *
     * @param type 升级类型
     */
    public MoreUpgradeItem(Item.Properties properties, UpgradeType type) {
        super(properties
                        // 物品存储修改器：应用容量倍率
                        .component(FSAttachments.ITEM_STORAGE_MODIFIER,
                                new SizeProvider.ModifyFactor(type.getMultiplier()))
                        // 流体存储修改器：应用容量倍率除以流体除数配置
                        .component(FSAttachments.FLUID_STORAGE_MODIFIER,
                                new SizeProvider.ModifyFactor(type.getMultiplier() / FunctionalStorageConfig.FLUID_DIVISOR))
                        // 控制器范围修改器：应用容量倍率除以范围除数配置
                        .component(FSAttachments.CONTROLLER_RANGE_MODIFIER,
                                new SizeProvider.ModifyFactor(type.getMultiplier() / FunctionalStorageConfig.RANGE_DIVISOR)),
                // 设置为存储类型升级
                UpgradeItem.Type.STORAGE);
        this.type = type;
    }

    /**
     * 获取物品的显示名称。
     * <p>
     * 名称颜色由升级类型决定。
     *
     * @param stack 物品堆
     * @return 带颜色样式的显示名称
     */
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return Component.translatable(getDescriptionId())
                .withStyle(style -> style.withColor(type.getColor()));
    }

    /**
     * 判断物品是否具有附魔光效。
     *
     * @param stack 物品堆
     * @return 具有附魔光效返回 true
     */
    public boolean isFoil(@NotNull ItemStack stack) {
        return type.hasGlint();
    }
}