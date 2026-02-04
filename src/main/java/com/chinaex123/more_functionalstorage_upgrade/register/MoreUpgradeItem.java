package com.chinaex123.more_functionalstorage_upgrade.register;

import com.buuz135.functionalstorage.item.UpgradeItem;
import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.component.SizeProvider;
import com.buuz135.functionalstorage.block.config.FunctionalStorageConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class MoreUpgradeItem extends UpgradeItem {

    // 升级类型枚举
    public enum UpgradeType {
        // 鳞甲升级
        TURTLE_SCUTE_UPGRADE("turtle_scute_upgrade", 48.0f, Mth.color(0/255f, 255/255f, 255/255f), false),
        // 下界之星升级
        NETHER_STAR_UPGRADE("nether_star_upgrade", 72.0f, Mth.color(255/255f, 215/255f, 0/255f), false),
        // 重锤升级
        HEAVY_CORE_UPGRADE("heavy_core_upgrade", 128.0f, Mth.color(153/255f, 50/255f, 204/255f), false);



        private final String name;          // 升级类型的名称
        private final float multiplier;     // 容量倍率
        private final int color;            // 物品名称颜色
        private final boolean hasGlint;     // 是否具有闪烁效果

        // 升级类型构造函数
        UpgradeType(String name, float multiplier, int color, boolean hasGlint) {
            this.name = name;
            this.multiplier = multiplier;
            this.color = color;
            this.hasGlint = hasGlint;
        }

        public String getName() {
            return name;
        }

        public float getMultiplier() {
            return multiplier;
        }

        public int getColor() {
            return color;
        }

        public boolean hasGlint() {
            return hasGlint;
        }
    }

    private final UpgradeType type; // 当前物品实例的升级类型

    // 更多升级物品
    public MoreUpgradeItem(UpgradeType type) {
        super(new Item.Properties()
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

    // 获取物品的显示名称
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return Component.translatable(getDescriptionId(stack))
                .withStyle(style -> style.withColor(type.getColor()));
    }

    // 查物品是否具有附魔光效
    public boolean isFoil(@NotNull ItemStack stack) {
        return type.hasGlint();
    }
}