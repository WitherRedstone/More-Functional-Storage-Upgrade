//package com.chinaex123.more_functionalstorage_upgrade.init.integrations;
//
//import com.buuz135.functionalstorage.item.FSAttachments;
//import com.buuz135.functionalstorage.item.FSItem;
//import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
//import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigFluidGeneration;
//import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigItemGeneration;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.Identifier;
//import net.minecraft.world.item.Item;
//import net.neoforged.fml.ModList;
//import net.neoforged.neoforge.fluids.FluidStack;
//import net.neoforged.neoforge.registries.DeferredItem;
//
//import static com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem.ITEMS;
//
///**
// * 机械动力模组兼容类
// * <p>
// * 用于在机械动力模组加载时，注册基于其材料与流体的生成升级物品。
// * 包含固体材料（如锆蓝石、绯红岩等）与流体（如蜂蜜）的生成升级，
// * 每类均按等级递增生成速率并缩短间隔。
// */
//public class CreateUpgradeItem {
//
//    /**
//     * 判断机械动力模组是否已加载。
//     *
//     * @return 已加载返回 true
//     */
//    public static boolean CREATE_LOADED() {
//        return ModList.get().isLoaded("create");
//    }
//
//    /**
//     * 根据流体 ID 和数量创建流体堆栈。
//     *
//     * @param fluidId 流体的资源位置标识符
//     * @param amount  流体的数量（毫桶）
//     * @return 对应的流体堆栈对象
//     */
//    private static FluidStack getFluid(String fluidId, int amount) {
//        var fluidHolder = BuiltInRegistries.FLUID.get(Identifier.parse(fluidId))
//                .orElseThrow(() -> new IllegalArgumentException("Unknown fluid: " + fluidId));
//        return new FluidStack(fluidHolder, amount);
//    }
//
//    /**
//     * 创建流体生成器升级。
//     *
//     * @param props          物品属性（由 DeferredRegister 自动设置好 id）
//     * @param fluidId        流体 ID
//     * @param generationRate 每次生成的流体量（mB）
//     * @param interval       生成间隔（刻）
//     * @return 流体生成升级物品
//     */
//    private static Item createFluidGenerator(Item.Properties props, String fluidId, int generationRate, int interval) {
//        return new FSItem(props.component(FSAttachments.FUNCTIONAL_BEHAVIOR,
//                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
//                        getFluid(fluidId, generationRate), generationRate, interval)
//                ))
//        );
//    }
//
//    /**
//     * 创建物品生成器升级。
//     * <p>
//     * 使用延迟获取物品的配置，避免模组间注册时机冲突。
//     *
//     * @param props    物品属性（由 DeferredRegister 自动设置好 id）
//     * @param itemId   物品 ID
//     * @param count    每次生成的数量
//     * @param interval 生成间隔（刻）
//     * @return 物品生成升级物品
//     */
//    private static Item createItemGenerator(Item.Properties props, String itemId, int count, int interval) {
//        return new FSItem(props.component(FSAttachments.FUNCTIONAL_BEHAVIOR,
//                new ExecuteEveryBehavior(interval, new ConfigItemGeneration.Delayed(
//                        itemId, count, interval)
//                ))
//        );
//    }
//
//    // 锆蓝石生成升级
//    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("asurine_generator_upgrade_1",
//            p -> createItemGenerator(p, "create:asurine", 8, 20));
//    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("asurine_generator_upgrade_2",
//            p -> createItemGenerator(p, "create:asurine", 16, 15));
//    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("asurine_generator_upgrade_3",
//            p -> createItemGenerator(p, "create:asurine", 32, 10));
//    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("asurine_generator_upgrade_4",
//            p -> createItemGenerator(p, "create:asurine", 64, 5));
//    public static final DeferredItem<Item> ASURINE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("asurine_generator_upgrade_5",
//            p -> createItemGenerator(p, "create:asurine", 64, 1));
//
//    // 绯红岩生成升级
//    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("crimsite_generator_upgrade_1",
//            p -> createItemGenerator(p, "create:crimsite", 8, 20));
//    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("crimsite_generator_upgrade_2",
//            p -> createItemGenerator(p, "create:crimsite", 16, 15));
//    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("crimsite_generator_upgrade_3",
//            p -> createItemGenerator(p, "create:crimsite", 32, 10));
//    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("crimsite_generator_upgrade_4",
//            p -> createItemGenerator(p, "create:crimsite", 64, 5));
//    public static final DeferredItem<Item> CRIMSITE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("crimsite_generator_upgrade_5",
//            p -> createItemGenerator(p, "create:crimsite", 64, 1));
//
//    // 赭金砂生成升级
//    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_1 = ITEMS.registerItem("ochrum_generator_upgrade_1",
//            p -> createItemGenerator(p, "create:ochrum", 8, 20));
//    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_2 = ITEMS.registerItem("ochrum_generator_upgrade_2",
//            p -> createItemGenerator(p, "create:ochrum", 16, 15));
//    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_3 = ITEMS.registerItem("ochrum_generator_upgrade_3",
//            p -> createItemGenerator(p, "create:ochrum", 32, 10));
//    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_4 = ITEMS.registerItem("ochrum_generator_upgrade_4",
//            p -> createItemGenerator(p, "create:ochrum", 64, 5));
//    public static final DeferredItem<Item> OCHRUM_GENERATOR_UPGRADE_5 = ITEMS.registerItem("ochrum_generator_upgrade_5",
//            p -> createItemGenerator(p, "create:ochrum", 64, 1));
//
//    // 辉绿岩生成升级
//    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_1 = ITEMS.registerItem("veridium_generator_upgrade_1",
//            p -> createItemGenerator(p, "create:veridium", 8, 20));
//    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_2 = ITEMS.registerItem("veridium_generator_upgrade_2",
//            p -> createItemGenerator(p, "create:veridium", 16, 15));
//    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_3 = ITEMS.registerItem("veridium_generator_upgrade_3",
//            p -> createItemGenerator(p, "create:veridium", 32, 10));
//    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_4 = ITEMS.registerItem("veridium_generator_upgrade_4",
//            p -> createItemGenerator(p, "create:veridium", 64, 5));
//    public static final DeferredItem<Item> VERIDIUM_GENERATOR_UPGRADE_5 = ITEMS.registerItem("veridium_generator_upgrade_5",
//            p -> createItemGenerator(p, "create:veridium", 64, 1));
//
//    // 石灰岩生成升级
//    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("limestone_generator_upgrade_1",
//            p -> createItemGenerator(p, "create:limestone", 8, 20));
//    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("limestone_generator_upgrade_2",
//            p -> createItemGenerator(p, "create:limestone", 16, 15));
//    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("limestone_generator_upgrade_3",
//            p -> createItemGenerator(p, "create:limestone", 32, 10));
//    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("limestone_generator_upgrade_4",
//            p -> createItemGenerator(p, "create:limestone", 64, 5));
//    public static final DeferredItem<Item> LIMESTONE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("limestone_generator_upgrade_5",
//            p -> createItemGenerator(p, "create:limestone", 64, 1));
//
//    // 熔渣生成升级
//    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_1 = ITEMS.registerItem("scoria_generator_upgrade_1",
//            p -> createItemGenerator(p, "create:scoria", 8, 20));
//    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_2 = ITEMS.registerItem("scoria_generator_upgrade_2",
//            p -> createItemGenerator(p, "create:scoria", 16, 15));
//    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_3 = ITEMS.registerItem("scoria_generator_upgrade_3",
//            p -> createItemGenerator(p, "create:scoria", 32, 10));
//    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_4 = ITEMS.registerItem("scoria_generator_upgrade_4",
//            p -> createItemGenerator(p, "create:scoria", 64, 5));
//    public static final DeferredItem<Item> SCORIA_GENERATOR_UPGRADE_5 = ITEMS.registerItem("scoria_generator_upgrade_5",
//            p -> createItemGenerator(p, "create:scoria", 64, 1));
//
//    // ==================== 流体功能升级 ====================
//
//    // 蜂蜜生成升级
//    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_1 = ITEMS.registerItem("honey_generator_upgrade_1",
//            p -> createFluidGenerator(p, "create:honey", 25, 20));
//    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_2 = ITEMS.registerItem("honey_generator_upgrade_2",
//            p -> createFluidGenerator(p, "create:honey", 100, 15));
//    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_3 = ITEMS.registerItem("honey_generator_upgrade_3",
//            p -> createFluidGenerator(p, "create:honey", 250, 10));
//    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_4 = ITEMS.registerItem("honey_generator_upgrade_4",
//            p -> createFluidGenerator(p, "create:honey", 500, 5));
//    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_5 = ITEMS.registerItem("honey_generator_upgrade_5",
//            p -> createFluidGenerator(p, "create:honey", 1000, 1));
//
//    public static void register() {}
//}