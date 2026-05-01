package com.chinaex123.more_functionalstorage_upgrade.init.ModCompat;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.init.Fluid.ConfigFluidGeneration;
import com.chinaex123.more_functionalstorage_upgrade.init.Item.ConfigItemGeneration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.chinaex123.more_functionalstorage_upgrade.init.Item.CustomUpgradeItem.ITEMS;

public class CreateCompat {

    // 检查 机械动力 是否已安装
    public static boolean CREATE_LOADED() {
        return ModList.get().isLoaded("create");
    }

    /**
     * 根据流体ID和数量创建流体堆栈
     *
     * @param fluidId 流体的资源位置标识符
     * @param amount 流体的数量（毫桶）
     * @return FluidStack 对应的流体堆栈对象
     * <p>
     * 此方法从内置注册表中获取指定ID的流体，并创建包含指定数量的流体堆栈。
     * 主要用于创建机械动力模组的流体生成升级物品。
     */
    private static FluidStack getFluid(String fluidId, int amount) {
        var fluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
        return new FluidStack(fluid, amount);
    }

    // ==================== 创建升级物品的工厂方法 ====================
    /**
     * 创建流体生成器升级
     * @param fluidId 流体ID
     * @param generationRate 每次生成的流体量(mB)
     * @param interval 生成间隔（刻）
     */
    private static Item createFluidGenerator(String fluidId, int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
                        getFluid(fluidId, generationRate), generationRate, interval)
                ))
        );
    }

    /**
     * 创建物品生成器升级
     * @param itemId 物品ID
     * @param count 每次生成的数量
     * @param interval 生成间隔（刻）
     */
    private static Item createItemGenerator(String itemId, int count, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigItemGeneration.Delayed(
                        itemId, count, interval)
                ))
        );
    }

    // ==================== 注册物品 ====================
    // 锆蓝石生成升级
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_1 =
            ITEMS.register("asurine_generator_upgrade_1",
                    () -> createItemGenerator("create:asurine", 8, 20));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_2 =
            ITEMS.register("asurine_generator_upgrade_2",
                    () -> createItemGenerator("create:asurine", 16, 15));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_3 =
            ITEMS.register("asurine_generator_upgrade_3",
                    () -> createItemGenerator("create:asurine", 32, 10));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_4 =
            ITEMS.register("asurine_generator_upgrade_4",
                    () -> createItemGenerator("create:asurine", 64, 5));
    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_5 =
            ITEMS.register("asurine_generator_upgrade_5",
                    () -> createItemGenerator("create:asurine", 64, 1));
    // 绯红岩生成升级
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_1 =
            ITEMS.register("crimsite_generator_upgrade_1",
                    () -> createItemGenerator("create:crimsite", 8, 20));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_2 =
            ITEMS.register("crimsite_generator_upgrade_2",
                    () -> createItemGenerator("create:crimsite", 16, 15));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_3 =
            ITEMS.register("crimsite_generator_upgrade_3",
                    () -> createItemGenerator("create:crimsite", 32, 10));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_4 =
            ITEMS.register("crimsite_generator_upgrade_4",
                    () -> createItemGenerator("create:crimsite", 64, 5));
    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_5 =
            ITEMS.register("crimsite_generator_upgrade_5",
                    () -> createItemGenerator("create:crimsite", 64, 1));
    // 赭金砂生成升级
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_1 =
            ITEMS.register("ochrum_generator_upgrade_1",
                    () -> createItemGenerator("create:ochrum", 8, 20));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_2 =
            ITEMS.register("ochrum_generator_upgrade_2",
                    () -> createItemGenerator("create:ochrum", 16, 15));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_3 =
            ITEMS.register("ochrum_generator_upgrade_3",
                    () -> createItemGenerator("create:ochrum", 32, 10));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_4 =
            ITEMS.register("ochrum_generator_upgrade_4",
                    () -> createItemGenerator("create:ochrum", 64, 5));
    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_5 =
            ITEMS.register("ochrum_generator_upgrade_5",
                    () -> createItemGenerator("create:ochrum", 64, 1));
    // 辉绿岩生成升级
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_1 =
            ITEMS.register("veridium_generator_upgrade_1",
                    () -> createItemGenerator("create:veridium", 8, 20));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_2 =
            ITEMS.register("veridium_generator_upgrade_2",
                    () -> createItemGenerator("create:veridium", 16, 15));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_3 =
            ITEMS.register("veridium_generator_upgrade_3",
                    () -> createItemGenerator("create:veridium", 32, 10));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_4 =
            ITEMS.register("veridium_generator_upgrade_4",
                    () -> createItemGenerator("create:veridium", 64, 5));
    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_5 =
            ITEMS.register("veridium_generator_upgrade_5",
                    () -> createItemGenerator("create:veridium", 64, 1));
    // 辉绿岩生成升级
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_1 =
            ITEMS.register("limestone_generator_upgrade_1",
                    () -> createItemGenerator("create:limestone", 8, 20));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_2 =
            ITEMS.register("limestone_generator_upgrade_2",
                    () -> createItemGenerator("create:limestone", 16, 15));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_3 =
            ITEMS.register("limestone_generator_upgrade_3",
                    () -> createItemGenerator("create:limestone", 32, 10));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_4 =
            ITEMS.register("limestone_generator_upgrade_4",
                    () -> createItemGenerator("create:limestone", 64, 5));
    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_5 =
            ITEMS.register("limestone_generator_upgrade_5",
                    () -> createItemGenerator("create:limestone", 64, 1));

    // 蜂蜜生成升级
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_1 =
            ITEMS.register("honey_generator_upgrade_1",
                    () -> createFluidGenerator("create:honey", 25, 20));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_2 =
            ITEMS.register("honey_generator_upgrade_2",
                    () -> createFluidGenerator("create:honey", 100, 15));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_3 =
            ITEMS.register("honey_generator_upgrade_3",
                    () -> createFluidGenerator("create:honey", 250, 10));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_4 =
            ITEMS.register("honey_generator_upgrade_4",
                    () -> createFluidGenerator("create:honey", 500, 5));
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_5 =
            ITEMS.register("honey_generator_upgrade_5",
                    () -> createFluidGenerator("create:honey", 1000, 1));

    // 注册方法，在主类中调用
    public static void register() {
        //var item = HONEY_GENERATOR_UPGRADE_1;
    }
}