package com.chinaex123.more_functionalstorage_upgrade.mixins.accessor;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * 创造模式物品栏界面访问器
 * <p>
 * 通过 Mixin 的 Accessor 机制访问 {@link CreativeModeInventoryScreen}
 * 的私有静态字段 {@code selectedTab}，用于获取当前选中的创造模式标签页。
 */
@Mixin(CreativeModeInventoryScreen.class)
public interface CreativeModeInventoryScreenAccessor {

    /**
     * 获取当前选中的创造模式标签页。
     *
     * @return 当前选中的创造模式标签页
     */
    @Accessor("selectedTab")
    static CreativeModeTab mfu$getSelectedTab() {
        throw new AssertionError();
    }
}