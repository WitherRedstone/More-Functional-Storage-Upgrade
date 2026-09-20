package com.chinaex123.more_functionalstorage_upgrade.init.integrations;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigItemGeneration;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem.ITEMS;

public class ForbiddenArcanusUpgradeItem {

    /**
     * 判断禁忌与奥秘模组是否已加载。
     *
     * @return 已加载返回 true
     */
    public static boolean FORBIDDEN_ARCANUS_LOADED() {
        return ModList.get().isLoaded("forbidden_arcanus");
    }

    /**
     * 创建物品生成器升级。
     * <p>
     * 使用延迟获取物品的配置，避免模组间注册时机冲突。
     *
     * @param itemId   物品 ID
     * @param count    每次生成的数量
     * @param interval 生成间隔（刻）
     * @return 物品生成升级物品
     */
    private static Item forbiddenArcanusItemGenerator(String itemId, int count, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigItemGeneration.Delayed(
                        itemId, count, interval)
                ))
        );
    }

    // 暗黑石生成升级
    public static final DeferredItem<Item> DARKSTONE_GENERATOR_UPGRADE_1 = ITEMS.register("darkstone_generator_upgrade_1",
            () -> forbiddenArcanusItemGenerator("forbidden_arcanus:darkstone", 8, 20));
    public static final DeferredItem<Item> DARKSTONE_GENERATOR_UPGRADE_2 = ITEMS.register("darkstone_generator_upgrade_2",
            () -> forbiddenArcanusItemGenerator("forbidden_arcanus:darkstone", 16, 15));
    public static final DeferredItem<Item> DARKSTONE_GENERATOR_UPGRADE_3 = ITEMS.register("darkstone_generator_upgrade_3",
            () -> forbiddenArcanusItemGenerator("forbidden_arcanus:darkstone", 32, 10));
    public static final DeferredItem<Item> DARKSTONE_GENERATOR_UPGRADE_4 = ITEMS.register("darkstone_generator_upgrade_4",
            () -> forbiddenArcanusItemGenerator("forbidden_arcanus:darkstone", 64, 5));
    public static final DeferredItem<Item> DARKSTONE_GENERATOR_UPGRADE_5 = ITEMS.register("darkstone_generator_upgrade_5",
            () -> forbiddenArcanusItemGenerator("forbidden_arcanus:darkstone", 64, 1));

    public static void register() {}
}
