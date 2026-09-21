package com.chinaex123.more_functionalstorage_upgrade.init;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.ForbiddenArcanusUpgradeItem;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreFunctionalStorageUpgrade.MOD_ID);

    /** 第一个按钮：基础升级 */
    public static final NonNullList<ItemStack> BASE_ITEMS = NonNullList.create();
    /** 第二个按钮：其他模组兼容升级 */
    public static final NonNullList<ItemStack> INTEGRATION_ITEMS = NonNullList.create();

    // ==================== 兼容模组 ID ====================
    private static final String MOD_CREATE = "create";
    private static final String MOD_FORBIDDEN_ARCANUS = "forbidden_arcanus";

    public static final Supplier<CreativeModeTab> MORE_FUNCTIONALSTORAGE_UPGRADE_TAB =
            CREATIVE_MODE_TAB.register("more_functionalstorage_upgrade_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()))
                    .title(Component.translatable("itemGroup.more_functionalstorage_upgrade_tab"))
                    .displayItems((parameters, output) -> {
                        BASE_ITEMS.clear();
                        INTEGRATION_ITEMS.clear();
                        addBaseItems(output);
                        addIntegrationItems(output);
                    })
                    .build());

    // ==================== 基础升级（第一个按钮） ====================
    private static void addBaseItems(CreativeModeTab.Output output) {
        accept(output, BASE_ITEMS, ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get()); // 升级锻造模板

        // 物品堆叠升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get()); // 鳞甲升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.NETHER_STAR_UPGRADE.get()); // 下界之星升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.HEAVY_CORE_UPGRADE.get()); // 重锤升级

        // ==================== 物品功能升级 ====================
        // 黑曜石生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_5.get());
        // 圆石生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_5.get());
        // 沙砾生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_5.get());
        // 泥土生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_5.get());
        // 沙子生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_5.get());
        // 安山岩生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_5.get());
        // 闪长岩生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_5.get());
        // 花岗岩生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_5.get());
        // 深板岩圆石生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5.get());
        // 黑石生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_5.get());
        // 下界岩生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_5.get());
        // 末地石生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_5.get());
        // 凝灰岩生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_5.get());
        // 玄武岩生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_5.get());
        // 滴水石块生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_5.get());
        // 海晶石生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_5.get());
        // 灵魂沙生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_5.get());
        // 幽匿块生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_5.get());
        // 黏土块生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_5.get());

        // ==================== 流体功能升级 ====================
        // 水生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_5.get());
        // 岩浆生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_5.get());
        // 牛奶生成升级
        accept(output, BASE_ITEMS, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get());
        accept(output, BASE_ITEMS, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_5.get());
    }

    // ==================== 兼容升级（第二个按钮） ====================

    /**
     * 调度所有模组的兼容物品。
     * <p>
     * 每个模组一个私有方法，各自判断是否加载。
     * 以后加新模组，在这里加一行调用即可。
     */
    private static void addIntegrationItems(CreativeModeTab.Output output) {
//        addCreateItems(output);
        addforbiddenArcanusItems(output);
    }

    /**
     * 机械动力兼容物品。
     * <p>
     * 仅在 Create 加载时添加。
     */
//    private static void addCreateItems(CreativeModeTab.Output output) {
//        if (!ModList.get().isLoaded(MOD_CREATE)) {
//            return;
//        }
//
//        // 锆蓝石生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_5.get());
//        // 绯红岩生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_5.get());
//        // 赭金砂生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_5.get());
//        // 辉绿岩生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_5.get());
//        // 石灰岩生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_5.get());
//        // 熔渣生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_5.get());
//        // 蜂蜜生成升级
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_2.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_3.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_4.get());
//        accept(output, INTEGRATION_ITEMS, CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_5.get());
//    }

    /**
     * 禁忌与奥秘兼容物品。
     * <p>
     * 仅在 禁忌与奥秘 加载时添加。
     */
     private static void addforbiddenArcanusItems(CreativeModeTab.Output output) {
         if (!ModList.get().isLoaded(MOD_FORBIDDEN_ARCANUS)) {
             return;
         }

         // 暗黑石生成升级
         accept(output, INTEGRATION_ITEMS, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_1.get());
         accept(output, INTEGRATION_ITEMS, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_2.get());
         accept(output, INTEGRATION_ITEMS, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_3.get());
         accept(output, INTEGRATION_ITEMS, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_4.get());
         accept(output, INTEGRATION_ITEMS, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_5.get());
     }

    /** 把物品输出到标签页，同时缓存到指定分类列表 */
    private static void accept(CreativeModeTab.Output output, NonNullList<ItemStack> categoryItems, ItemLike item) {
        ItemStack stack = new ItemStack(item);
        output.accept(stack);
        categoryItems.add(stack.copy());
    }

    /** 把物品栈输出到标签页，同时缓存到指定分类列表 */
    private static void accept(CreativeModeTab.Output output, NonNullList<ItemStack> categoryItems, ItemStack stack) {
        output.accept(stack);
        categoryItems.add(stack.copy());
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}