package com.chinaex123.more_functionalstorage_upgrade.init.integrations;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigFluidGeneration;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigItemGeneration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem.ITEMS;

/**
 * 机械动力模组兼容类
 * <p>
 * 用于在机械动力模组加载时，注册基于其材料与流体的生成升级物品。
 * 包含固体材料（如锆蓝石、绯红岩等）与流体（如蜂蜜）的生成升级，
 * 每类均按等级递增生成速率并缩短间隔。
 */
public class CreateUpgradeItem {

    /**
     * 判断机械动力模组是否已加载。
     *
     * @return 已加载返回 true
     */
    public static boolean CREATE_LOADED() {
        return ModList.get().isLoaded("create");
    }

    /**
     * 根据流体 ID 和数量创建流体堆栈。
     *
     * @param fluidId 流体的资源位置标识符
     * @param amount  流体的数量（毫桶）
     * @return 对应的流体堆栈对象
     */
    private static FluidStack getFluid(String fluidId, int amount) {
        var fluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
        return new FluidStack(fluid, amount);
    }

    /**
     * 创建流体生成器升级。
     *
     * @param fluidId        流体 ID
     * @param generationRate 每次生成的流体量（mB）
     * @param interval       生成间隔（刻）
     * @return 流体生成升级物品
     */
    private static Item createFluidGenerator(String fluidId, int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
                        getFluid(fluidId, generationRate), generationRate, interval)
                ))
        );
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
    private static Item createItemGenerator(String itemId, int count, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigItemGeneration.Delayed(
                        itemId, count, interval)
                ))
        );
    }

    // 锆蓝石生成升级
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_1 = ITEMS.register("asurine_generator_upgrade_1",
            () -> createItemGenerator("create:asurine", 8, 20));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_2 = ITEMS.register("asurine_generator_upgrade_2",
            () -> createItemGenerator("create:asurine", 16, 15));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_3 = ITEMS.register("asurine_generator_upgrade_3",
            () -> createItemGenerator("create:asurine", 32, 10));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_4 = ITEMS.register("asurine_generator_upgrade_4",
            () -> createItemGenerator("create:asurine", 64, 5));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_5 = ITEMS.register("asurine_generator_upgrade_5",
            () -> createItemGenerator("create:asurine", 64, 1));
    // 绯红岩生成升级
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_1 = ITEMS.register("crimsite_generator_upgrade_1",
            () -> createItemGenerator("create:crimsite", 8, 20));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_2 = ITEMS.register("crimsite_generator_upgrade_2",
            () -> createItemGenerator("create:crimsite", 16, 15));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_3 = ITEMS.register("crimsite_generator_upgrade_3",
            () -> createItemGenerator("create:crimsite", 32, 10));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_4 = ITEMS.register("crimsite_generator_upgrade_4",
            () -> createItemGenerator("create:crimsite", 64, 5));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_5 = ITEMS.register("crimsite_generator_upgrade_5",
            () -> createItemGenerator("create:crimsite", 64, 1));
    // 赭金砂生成升级
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_1 = ITEMS.register("ochrum_generator_upgrade_1",
            () -> createItemGenerator("create:ochrum", 8, 20));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_2 = ITEMS.register("ochrum_generator_upgrade_2",
            () -> createItemGenerator("create:ochrum", 16, 15));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_3 = ITEMS.register("ochrum_generator_upgrade_3",
            () -> createItemGenerator("create:ochrum", 32, 10));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_4 = ITEMS.register("ochrum_generator_upgrade_4",
            () -> createItemGenerator("create:ochrum", 64, 5));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_5 = ITEMS.register("ochrum_generator_upgrade_5",
            () -> createItemGenerator("create:ochrum", 64, 1));
    // 辉绿岩生成升级
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_1 = ITEMS.register("veridium_generator_upgrade_1",
            () -> createItemGenerator("create:veridium", 8, 20));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_2 = ITEMS.register("veridium_generator_upgrade_2",
            () -> createItemGenerator("create:veridium", 16, 15));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_3 = ITEMS.register("veridium_generator_upgrade_3",
            () -> createItemGenerator("create:veridium", 32, 10));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_4 = ITEMS.register("veridium_generator_upgrade_4",
            () -> createItemGenerator("create:veridium", 64, 5));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_5 = ITEMS.register("veridium_generator_upgrade_5",
            () -> createItemGenerator("create:veridium", 64, 1));
    // 石灰岩生成升级
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_1 = ITEMS.register("limestone_generator_upgrade_1",
            () -> createItemGenerator("create:limestone", 8, 20));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_2 = ITEMS.register("limestone_generator_upgrade_2",
            () -> createItemGenerator("create:limestone", 16, 15));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_3 = ITEMS.register("limestone_generator_upgrade_3",
            () -> createItemGenerator("create:limestone", 32, 10));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_4 = ITEMS.register("limestone_generator_upgrade_4",
            () -> createItemGenerator("create:limestone", 64, 5));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_5 = ITEMS.register("limestone_generator_upgrade_5",
            () -> createItemGenerator("create:limestone", 64, 1));
    // 熔渣生成升级
    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_1 = ITEMS.register("scoria_generator_upgrade_1",
            () -> createItemGenerator("create:scoria", 8, 20));
    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_2 = ITEMS.register("scoria_generator_upgrade_2",
            () -> createItemGenerator("create:scoria", 16, 15));
    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_3 = ITEMS.register("scoria_generator_upgrade_3",
            () -> createItemGenerator("create:scoria", 32, 10));
    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_4 = ITEMS.register("scoria_generator_upgrade_4",
            () -> createItemGenerator("create:scoria", 64, 5));
    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_5 = ITEMS.register("scoria_generator_upgrade_5",
            () -> createItemGenerator("create:scoria", 64, 1));

    // ==================== 流体功能升级 ====================

    // 蜂蜜生成升级
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_1 = ITEMS.register("honey_generator_upgrade_1",
            () -> createFluidGenerator("create:honey", 25, 20));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_2 = ITEMS.register("honey_generator_upgrade_2",
            () -> createFluidGenerator("create:honey", 100, 15));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_3 = ITEMS.register("honey_generator_upgrade_3",
            () -> createFluidGenerator("create:honey", 250, 10));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_4 = ITEMS.register("honey_generator_upgrade_4",
            () -> createFluidGenerator("create:honey", 500, 5));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_5 = ITEMS.register("honey_generator_upgrade_5",
            () -> createFluidGenerator("create:honey", 1000, 1));

    public static void register() {}
}