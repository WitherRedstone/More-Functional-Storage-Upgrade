package com.chinaex123.more_functionalstorage_upgrade.init;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigFluidGeneration;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigItemGeneration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 自定义升级物品注册类
 * <p>
 * 负责注册本模组的所有升级物品，包括：
 * 物品堆叠升级、物品功能升级（各类方块生成）与流体功能升级（各类流体生成）。
 * 通过延迟注册器统一注册到模组事件总线。
 */
public class CustomUpgradeItem {

    /** 物品延迟注册器 */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreFunctionalStorageUpgrade.MOD_ID);

    /**
     * 创建物品生成器升级。
     *
     * @param itemToGenerate 要生成的物品和数量
     * @param generationRate 每次生成的数量
     * @param interval       生成间隔（刻）
     * @return 物品生成升级物品
     */
    private static Item createItemGenerator(ItemStack itemToGenerate, int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigItemGeneration(
                        itemToGenerate, generationRate, interval)
                ))
        );
    }

    /**
     * 创建流体生成器升级。
     *
     * @param fluidToGenerate 要生成的流体和数量
     * @param generationRate  每次生成的流体量（mB）
     * @param interval        生成间隔（刻）
     * @return 流体生成升级物品
     */
    private static Item createFluidGenerator(FluidStack fluidToGenerate, int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
                        fluidToGenerate, generationRate, interval)
                ))
        );
    }

    /**
     * 根据流体 ID 和数量创建流体堆栈。
     * <p>
     * 此方法从内置注册表中获取指定 ID 的流体，并创建包含指定数量的流体堆栈。
     *
     * @param fluidId 流体的资源位置标识符
     * @param amount  流体的数量（毫桶）
     * @return 对应的流体堆栈对象
     */
    private static FluidStack getFluid(String fluidId, int amount) {
        var fluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
        return new FluidStack(fluid, amount);
    }

    // ==================== 物品堆叠升级 ====================

    // 海龟鳞片升级
    public static final DeferredItem<MoreUpgradeItem> TURTLE_SCUTE_UPGRADE = ITEMS.register("turtle_scute_upgrade",
            () -> new MoreUpgradeItem(MoreUpgradeItem.UpgradeType.TURTLE_SCUTE_UPGRADE));
    // 下界之星升级
    public static final DeferredItem<MoreUpgradeItem> NETHER_STAR_UPGRADE = ITEMS.register("nether_star_upgrade",
            () -> new MoreUpgradeItem(MoreUpgradeItem.UpgradeType.NETHER_STAR_UPGRADE));
    // 重锤升级
    public static final DeferredItem<MoreUpgradeItem> HEAVY_CORE_UPGRADE = ITEMS.register("heavy_core_upgrade",
            () -> new MoreUpgradeItem(MoreUpgradeItem.UpgradeType.HEAVY_CORE_UPGRADE));


    // ==================== 物品功能升级 ====================

    // 黑曜石生成升级
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_1 = ITEMS.register("obsidian_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.OBSIDIAN, 8), 8, 200));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_2 = ITEMS.register("obsidian_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.OBSIDIAN, 32), 16, 80));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_3 = ITEMS.register("obsidian_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.OBSIDIAN, 64), 32, 20));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_4 = ITEMS.register("obsidian_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.OBSIDIAN, 64), 64, 5));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_5 = ITEMS.register("obsidian_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.OBSIDIAN, 64), 64, 1));
    // 圆石生成升级
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_1 = ITEMS.register("cobblestone_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.COBBLESTONE, 8), 8, 20));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_2 = ITEMS.register("cobblestone_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.COBBLESTONE, 16), 16, 15));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_3 = ITEMS.register("cobblestone_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.COBBLESTONE, 32), 32, 10));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_4 = ITEMS.register("cobblestone_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.COBBLESTONE, 64), 64, 5));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_5 = ITEMS.register("cobblestone_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.COBBLESTONE, 64), 64, 1));
    // 沙砾生成升级
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_1 = ITEMS.register("gravel_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.GRAVEL, 8), 8, 20));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_2 = ITEMS.register("gravel_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.GRAVEL, 16), 16, 15));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_3 = ITEMS.register("gravel_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.GRAVEL, 32), 32, 10));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_4 = ITEMS.register("gravel_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.GRAVEL, 64), 64, 5));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_5 = ITEMS.register("gravel_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.GRAVEL, 64), 64, 1));
    // 泥土生成升级
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_1 = ITEMS.register("dirt_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.DIRT, 8), 8, 20));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_2 = ITEMS.register("dirt_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.DIRT, 16), 16, 15));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_3 = ITEMS.register("dirt_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.DIRT, 32), 32, 10));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_4 = ITEMS.register("dirt_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.DIRT, 64), 64, 5));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_5 = ITEMS.register("dirt_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.DIRT, 64), 64, 1));
    // 沙子生成升级
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_1 = ITEMS.register("sand_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.SAND, 8), 8, 20));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_2 = ITEMS.register("sand_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.SAND, 16), 16, 15));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_3 = ITEMS.register("sand_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.SAND, 32), 32, 10));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_4 = ITEMS.register("sand_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.SAND, 64), 64, 5));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_5 = ITEMS.register("sand_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.SAND, 64), 64, 1));
    // 安山岩生成升级
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_1 = ITEMS.register("andesite_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.ANDESITE, 8), 8, 20));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_2 = ITEMS.register("andesite_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.ANDESITE, 16), 16, 15));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_3 = ITEMS.register("andesite_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.ANDESITE, 32), 32, 10));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_4 = ITEMS.register("andesite_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.ANDESITE, 64), 64, 5));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_5 = ITEMS.register("andesite_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.ANDESITE, 64), 64, 1));
    // 闪长岩生成升级
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_1 = ITEMS.register("diorite_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.DIORITE, 8), 8, 20));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_2 = ITEMS.register("diorite_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.DIORITE, 16), 16, 15));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_3 = ITEMS.register("diorite_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.DIORITE, 32), 32, 10));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_4 = ITEMS.register("diorite_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.DIORITE, 64), 64, 5));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_5 = ITEMS.register("diorite_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.DIORITE, 64), 64, 1));
    // 花岗岩生成升级
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_1 = ITEMS.register("granite_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.GRANITE, 8), 8, 20));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_2 = ITEMS.register("granite_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.GRANITE, 16), 16, 15));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_3 = ITEMS.register("granite_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.GRANITE, 32), 32, 10));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_4 = ITEMS.register("granite_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.GRANITE, 64), 64, 5));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_5 = ITEMS.register("granite_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.GRANITE, 64), 64, 1));
    // 深板岩圆石生成升级
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1 = ITEMS.register("cobbled_deepslate_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 8), 8, 20));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2 = ITEMS.register("cobbled_deepslate_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 16), 16, 15));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3 = ITEMS.register("cobbled_deepslate_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 32), 32, 10));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4 = ITEMS.register("cobbled_deepslate_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 64), 64, 5));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5 = ITEMS.register("cobbled_deepslate_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 64), 64, 1));
    // 黑石生成升级
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_1 = ITEMS.register("blackstone_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.BLACKSTONE, 8), 8, 20));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_2 = ITEMS.register("blackstone_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.BLACKSTONE, 16), 16, 15));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_3 = ITEMS.register("blackstone_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.BLACKSTONE, 32), 32, 10));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_4 = ITEMS.register("blackstone_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.BLACKSTONE, 64), 64, 5));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_5 = ITEMS.register("blackstone_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.BLACKSTONE, 64), 64, 1));
    // 下界岩生成升级
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_1 = ITEMS.register("netherrack_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.NETHERRACK, 8), 8, 20));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_2 = ITEMS.register("netherrack_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.NETHERRACK, 16), 16, 15));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_3 = ITEMS.register("netherrack_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.NETHERRACK, 32), 32, 10));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_4 = ITEMS.register("netherrack_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.NETHERRACK, 64), 64, 5));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_5 = ITEMS.register("netherrack_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.NETHERRACK, 64), 64, 1));
    // 末地石生成升级
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_1 = ITEMS.register("end_stone_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.END_STONE, 8), 8, 20));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_2 = ITEMS.register("end_stone_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.END_STONE, 16), 16, 15));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_3 = ITEMS.register("end_stone_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.END_STONE, 32), 32, 10));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_4 = ITEMS.register("end_stone_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.END_STONE, 64), 64, 5));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_5 = ITEMS.register("end_stone_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.END_STONE, 64), 64, 1));
    // 凝灰岩生成升级
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_1 = ITEMS.register("tuff_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.TUFF, 8), 8, 20));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_2 = ITEMS.register("tuff_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.TUFF, 16), 16, 15));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_3 = ITEMS.register("tuff_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.TUFF, 32), 32, 10));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_4 = ITEMS.register("tuff_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.TUFF, 64), 64, 5));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_5 = ITEMS.register("tuff_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.TUFF, 64), 64, 1));
    // 玄武岩生成升级
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_1 = ITEMS.register("basalt_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.BASALT, 8), 8, 20));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_2 = ITEMS.register("basalt_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.BASALT, 16), 16, 15));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_3 = ITEMS.register("basalt_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.BASALT, 32), 32, 10));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_4 = ITEMS.register("basalt_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.BASALT, 64), 64, 5));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_5 = ITEMS.register("basalt_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.BASALT, 64), 64, 1));
    // 滴水石块生成升级
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_1 = ITEMS.register("dripstone_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.DRIPSTONE_BLOCK, 8), 8, 20));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_2 = ITEMS.register("dripstone_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.DRIPSTONE_BLOCK, 16), 16, 15));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_3 = ITEMS.register("dripstone_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.DRIPSTONE_BLOCK, 32), 32, 10));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_4 = ITEMS.register("dripstone_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.DRIPSTONE_BLOCK, 64), 64, 5));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_5 = ITEMS.register("dripstone_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.DRIPSTONE_BLOCK, 64), 64, 1));
    // 海晶石生成升级
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_1 = ITEMS.register("prismarine_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.PRISMARINE, 8), 8, 20));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_2 = ITEMS.register("prismarine_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.PRISMARINE, 16), 16, 15));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_3 = ITEMS.register("prismarine_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.PRISMARINE, 32), 32, 10));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_4 = ITEMS.register("prismarine_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.PRISMARINE, 64), 64, 5));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_5 = ITEMS.register("prismarine_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.PRISMARINE, 64), 64, 1));
    // 灵魂沙生成升级
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_1 = ITEMS.register("soul_sand_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.SOUL_SAND, 8), 8, 20));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_2 = ITEMS.register("soul_sand_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.SOUL_SAND, 16), 16, 15));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_3 = ITEMS.register("soul_sand_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.SOUL_SAND, 32), 32, 10));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_4 = ITEMS.register("soul_sand_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.SOUL_SAND, 64), 64, 5));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_5 = ITEMS.register("soul_sand_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.SOUL_SAND, 64), 64, 1));
    // 幽匿块生成升级
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_1 = ITEMS.register("sculk_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.SCULK, 8), 8, 20));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_2 = ITEMS.register("sculk_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.SCULK, 16), 16, 15));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_3 = ITEMS.register("sculk_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.SCULK, 32), 32, 10));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_4 = ITEMS.register("sculk_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.SCULK, 64), 64, 5));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_5 = ITEMS.register("sculk_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.SCULK, 64), 64, 1));
    // 黏土块生成升级
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_1 = ITEMS.register("clay_generator_upgrade_1",
            () -> createItemGenerator(new ItemStack(Items.CLAY, 8), 8, 20));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_2 = ITEMS.register("clay_generator_upgrade_2",
            () -> createItemGenerator(new ItemStack(Items.CLAY, 16), 16, 15));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_3 = ITEMS.register("clay_generator_upgrade_3",
            () -> createItemGenerator(new ItemStack(Items.CLAY, 32), 32, 10));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_4 = ITEMS.register("clay_generator_upgrade_4",
            () -> createItemGenerator(new ItemStack(Items.CLAY, 64), 64, 5));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_5 = ITEMS.register("clay_generator_upgrade_5",
            () -> createItemGenerator(new ItemStack(Items.CLAY, 64), 64, 1));

    // ==================== 流体功能升级 ====================

    // 水生成升级
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_1 = ITEMS.register("water_generator_upgrade_1",
            () -> createFluidGenerator(new FluidStack(Fluids.WATER, 32000), 32000, 20));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_2 = ITEMS.register("water_generator_upgrade_2",
            () -> createFluidGenerator(new FluidStack(Fluids.WATER, 128000), 128000, 15));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_3 = ITEMS.register("water_generator_upgrade_3",
            () -> createFluidGenerator(new FluidStack(Fluids.WATER, 512000), 512000, 10));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_4 = ITEMS.register("water_generator_upgrade_4",
            () -> createFluidGenerator(new FluidStack(Fluids.WATER, 1024000), 1024000, 5));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_5 = ITEMS.register("water_generator_upgrade_5",
            () -> createFluidGenerator(new FluidStack(Fluids.WATER, 2048000), 2048000, 1));
    // 岩浆生成升级
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_1 = ITEMS.register("lava_generator_upgrade_1",
            () -> createFluidGenerator(new FluidStack(Fluids.LAVA, 50), 50, 20));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_2 = ITEMS.register("lava_generator_upgrade_2",
            () -> createFluidGenerator(new FluidStack(Fluids.LAVA, 250), 250, 15));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_3 = ITEMS.register("lava_generator_upgrade_3",
            () -> createFluidGenerator(new FluidStack(Fluids.LAVA, 1000), 1000, 10));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_4 = ITEMS.register("lava_generator_upgrade_4",
            () -> createFluidGenerator(new FluidStack(Fluids.LAVA, 2500), 2500, 5));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_5 = ITEMS.register("lava_generator_upgrade_5",
            () -> createFluidGenerator(new FluidStack(Fluids.LAVA, 5000), 5000, 1));
    // 牛奶生成升级
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_1 = ITEMS.register("milk_generator_upgrade_1",
            () -> createFluidGenerator(getFluid("minecraft:milk", 50), 50, 20));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_2 = ITEMS.register("milk_generator_upgrade_2",
            () -> createFluidGenerator(getFluid("minecraft:milk", 250), 250, 15));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_3 = ITEMS.register("milk_generator_upgrade_3",
            () -> createFluidGenerator(getFluid("minecraft:milk", 1000), 1000, 10));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_4 = ITEMS.register("milk_generator_upgrade_4",
            () -> createFluidGenerator(getFluid("minecraft:milk", 2500), 2500, 5));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_5 = ITEMS.register("milk_generator_upgrade_5",
            () -> createFluidGenerator(getFluid("minecraft:milk", 5000), 5000, 1));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}