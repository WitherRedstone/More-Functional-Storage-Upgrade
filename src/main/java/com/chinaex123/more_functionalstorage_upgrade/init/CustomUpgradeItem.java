package com.chinaex123.more_functionalstorage_upgrade.init;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigFluidGeneration;
import com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior.ConfigItemGeneration;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
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
     * <p>
     * 使用延迟获取物品的配置，避免模组间注册时机冲突，
     * 同时避免在注册阶段构造 ItemStack（1.21.2+ 组件未绑定会 NPE）。
     *
     * @param props          物品属性（由 DeferredRegister 自动设置好 id）
     * @param itemId         要生成的物品 ID（延迟解析）
     * @param generationRate 每次生成的数量
     * @param interval       生成间隔（刻）
     * @return 物品生成升级物品
     */
    private static Item createItemGenerator(Item.Properties props, String itemId, int generationRate, int interval) {
        return new FSItem(props.component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigItemGeneration.Delayed(
                        itemId, generationRate, interval)
                ))
        );
    }

    /**
     * 创建流体生成器升级。
     *
     * @param props          物品属性（由 DeferredRegister 自动设置好 id）
     * @param fluidId        要生成的流体 ID（延迟解析）
     * @param generationRate 每次生成的流体量（mB）
     * @param interval       生成间隔（刻）
     * @return 流体生成升级物品
     */
    private static Item createFluidGenerator(Item.Properties props, String fluidId, int generationRate, int interval) {
        return new FSItem(props.component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
                        fluidId, generationRate, interval)
                ))
        );
    }

    // ==================== 物品堆叠升级 ====================

    // 海龟鳞片升级
    public static final DeferredItem<MoreUpgradeItem> TURTLE_SCUTE_UPGRADE = ITEMS.registerItem("turtle_scute_upgrade",
            p -> new MoreUpgradeItem(p, MoreUpgradeItem.UpgradeType.TURTLE_SCUTE_UPGRADE));
    // 下界之星升级
    public static final DeferredItem<MoreUpgradeItem> NETHER_STAR_UPGRADE = ITEMS.registerItem("nether_star_upgrade",
            p -> new MoreUpgradeItem(p, MoreUpgradeItem.UpgradeType.NETHER_STAR_UPGRADE));
    // 重锤升级
    public static final DeferredItem<MoreUpgradeItem> HEAVY_CORE_UPGRADE = ITEMS.registerItem("heavy_core_upgrade",
            p -> new MoreUpgradeItem(p, MoreUpgradeItem.UpgradeType.HEAVY_CORE_UPGRADE));


    // ==================== 物品功能升级 ====================

    // 黑曜石生成升级
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_1 = ITEMS.registerItem("obsidian_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:obsidian", 8, 200));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_2 = ITEMS.registerItem("obsidian_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:obsidian", 16, 80));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_3 = ITEMS.registerItem("obsidian_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:obsidian", 32, 20));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_4 = ITEMS.registerItem("obsidian_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:obsidian", 64, 5));
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_5 = ITEMS.registerItem("obsidian_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:obsidian", 64, 1));

    // 圆石生成升级
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("cobblestone_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:cobblestone", 8, 20));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("cobblestone_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:cobblestone", 16, 15));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("cobblestone_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:cobblestone", 32, 10));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("cobblestone_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:cobblestone", 64, 5));
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("cobblestone_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:cobblestone", 64, 1));

    // 沙砾生成升级
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_1 = ITEMS.registerItem("gravel_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:gravel", 8, 20));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_2 = ITEMS.registerItem("gravel_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:gravel", 16, 15));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_3 = ITEMS.registerItem("gravel_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:gravel", 32, 10));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_4 = ITEMS.registerItem("gravel_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:gravel", 64, 5));
    public static final DeferredItem<Item> GRAVEL_GENERATOR_UPGRADE_5 = ITEMS.registerItem("gravel_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:gravel", 64, 1));

    // 泥土生成升级
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_1 = ITEMS.registerItem("dirt_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:dirt", 8, 20));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_2 = ITEMS.registerItem("dirt_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:dirt", 16, 15));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_3 = ITEMS.registerItem("dirt_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:dirt", 32, 10));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_4 = ITEMS.registerItem("dirt_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:dirt", 64, 5));
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_5 = ITEMS.registerItem("dirt_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:dirt", 64, 1));

    // 沙子生成升级
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_1 = ITEMS.registerItem("sand_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:sand", 8, 20));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_2 = ITEMS.registerItem("sand_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:sand", 16, 15));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_3 = ITEMS.registerItem("sand_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:sand", 32, 10));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_4 = ITEMS.registerItem("sand_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:sand", 64, 5));
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_5 = ITEMS.registerItem("sand_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:sand", 64, 1));

    // 安山岩生成升级
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("andesite_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:andesite", 8, 20));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("andesite_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:andesite", 16, 15));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("andesite_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:andesite", 32, 10));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("andesite_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:andesite", 64, 5));
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("andesite_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:andesite", 64, 1));

    // 闪长岩生成升级
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("diorite_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:diorite", 8, 20));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("diorite_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:diorite", 16, 15));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("diorite_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:diorite", 32, 10));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("diorite_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:diorite", 64, 5));
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("diorite_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:diorite", 64, 1));

    // 花岗岩生成升级
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("granite_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:granite", 8, 20));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("granite_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:granite", 16, 15));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("granite_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:granite", 32, 10));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("granite_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:granite", 64, 5));
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("granite_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:granite", 64, 1));

    // 深板岩圆石生成升级
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("cobbled_deepslate_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:cobbled_deepslate", 8, 20));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("cobbled_deepslate_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:cobbled_deepslate", 16, 15));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("cobbled_deepslate_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:cobbled_deepslate", 32, 10));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("cobbled_deepslate_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:cobbled_deepslate", 64, 5));
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("cobbled_deepslate_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:cobbled_deepslate", 64, 1));

    // 黑石生成升级
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("blackstone_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:blackstone", 8, 20));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("blackstone_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:blackstone", 16, 15));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("blackstone_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:blackstone", 32, 10));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("blackstone_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:blackstone", 64, 5));
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("blackstone_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:blackstone", 64, 1));

    // 下界岩生成升级
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_1 = ITEMS.registerItem("netherrack_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:netherrack", 8, 20));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_2 = ITEMS.registerItem("netherrack_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:netherrack", 16, 15));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_3 = ITEMS.registerItem("netherrack_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:netherrack", 32, 10));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_4 = ITEMS.registerItem("netherrack_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:netherrack", 64, 5));
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_5 = ITEMS.registerItem("netherrack_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:netherrack", 64, 1));

    // 末地石生成升级
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("end_stone_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:end_stone", 8, 20));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("end_stone_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:end_stone", 16, 15));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("end_stone_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:end_stone", 32, 10));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("end_stone_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:end_stone", 64, 5));
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("end_stone_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:end_stone", 64, 1));

    // 凝灰岩生成升级
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_1 = ITEMS.registerItem("tuff_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:tuff", 8, 20));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_2 = ITEMS.registerItem("tuff_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:tuff", 16, 15));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_3 = ITEMS.registerItem("tuff_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:tuff", 32, 10));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_4 = ITEMS.registerItem("tuff_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:tuff", 64, 5));
    public static final DeferredItem<Item> TUFF_GENERATOR_UPGRADE_5 = ITEMS.registerItem("tuff_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:tuff", 64, 1));

    // 玄武岩生成升级
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_1 = ITEMS.registerItem("basalt_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:basalt", 8, 20));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_2 = ITEMS.registerItem("basalt_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:basalt", 16, 15));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_3 = ITEMS.registerItem("basalt_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:basalt", 32, 10));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_4 = ITEMS.registerItem("basalt_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:basalt", 64, 5));
    public static final DeferredItem<Item> BASALT_GENERATOR_UPGRADE_5 = ITEMS.registerItem("basalt_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:basalt", 64, 1));

    // 滴水石块生成升级
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("dripstone_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:dripstone_block", 8, 20));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("dripstone_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:dripstone_block", 16, 15));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("dripstone_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:dripstone_block", 32, 10));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("dripstone_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:dripstone_block", 64, 5));
    public static final DeferredItem<Item> DRIPSTONE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("dripstone_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:dripstone_block", 64, 1));

    // 海晶石生成升级
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_1 = ITEMS.registerItem("prismarine_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:prismarine", 8, 20));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_2 = ITEMS.registerItem("prismarine_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:prismarine", 16, 15));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_3 = ITEMS.registerItem("prismarine_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:prismarine", 32, 10));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_4 = ITEMS.registerItem("prismarine_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:prismarine", 64, 5));
    public static final DeferredItem<Item> PRISMARINE_GENERATOR_UPGRADE_5 = ITEMS.registerItem("prismarine_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:prismarine", 64, 1));

    // 灵魂沙生成升级
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_1 = ITEMS.registerItem("soul_sand_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:soul_sand", 8, 20));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_2 = ITEMS.registerItem("soul_sand_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:soul_sand", 16, 15));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_3 = ITEMS.registerItem("soul_sand_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:soul_sand", 32, 10));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_4 = ITEMS.registerItem("soul_sand_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:soul_sand", 64, 5));
    public static final DeferredItem<Item> SOUL_SAND_GENERATOR_UPGRADE_5 = ITEMS.registerItem("soul_sand_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:soul_sand", 64, 1));

    // 幽匿块生成升级
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_1 = ITEMS.registerItem("sculk_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:sculk", 8, 20));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_2 = ITEMS.registerItem("sculk_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:sculk", 16, 15));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_3 = ITEMS.registerItem("sculk_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:sculk", 32, 10));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_4 = ITEMS.registerItem("sculk_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:sculk", 64, 5));
    public static final DeferredItem<Item> SCULK_GENERATOR_UPGRADE_5 = ITEMS.registerItem("sculk_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:sculk", 64, 1));

    // 黏土块生成升级
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_1 = ITEMS.registerItem("clay_generator_upgrade_1",
            p -> createItemGenerator(p, "minecraft:clay", 8, 20));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_2 = ITEMS.registerItem("clay_generator_upgrade_2",
            p -> createItemGenerator(p, "minecraft:clay", 16, 15));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_3 = ITEMS.registerItem("clay_generator_upgrade_3",
            p -> createItemGenerator(p, "minecraft:clay", 32, 10));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_4 = ITEMS.registerItem("clay_generator_upgrade_4",
            p -> createItemGenerator(p, "minecraft:clay", 64, 5));
    public static final DeferredItem<Item> CLAY_GENERATOR_UPGRADE_5 = ITEMS.registerItem("clay_generator_upgrade_5",
            p -> createItemGenerator(p, "minecraft:clay", 64, 1));

    // ==================== 流体功能升级 ====================

    // 水生成升级
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_1 = ITEMS.registerItem("water_generator_upgrade_1",
            p -> createFluidGenerator(p, "minecraft:water", 32000, 20));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_2 = ITEMS.registerItem("water_generator_upgrade_2",
            p -> createFluidGenerator(p, "minecraft:water", 128000, 15));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_3 = ITEMS.registerItem("water_generator_upgrade_3",
            p -> createFluidGenerator(p, "minecraft:water", 512000, 10));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_4 = ITEMS.registerItem("water_generator_upgrade_4",
            p -> createFluidGenerator(p, "minecraft:water", 1024000, 5));
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_5 = ITEMS.registerItem("water_generator_upgrade_5",
            p -> createFluidGenerator(p, "minecraft:water", 2048000, 1));

    // 岩浆生成升级
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_1 = ITEMS.registerItem("lava_generator_upgrade_1",
            p -> createFluidGenerator(p, "minecraft:lava", 50, 20));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_2 = ITEMS.registerItem("lava_generator_upgrade_2",
            p -> createFluidGenerator(p, "minecraft:lava", 250, 15));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_3 = ITEMS.registerItem("lava_generator_upgrade_3",
            p -> createFluidGenerator(p, "minecraft:lava", 1000, 10));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_4 = ITEMS.registerItem("lava_generator_upgrade_4",
            p -> createFluidGenerator(p, "minecraft:lava", 2500, 5));
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_5 = ITEMS.registerItem("lava_generator_upgrade_5",
            p -> createFluidGenerator(p, "minecraft:lava", 5000, 1));

    // 牛奶生成升级
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_1 = ITEMS.registerItem("milk_generator_upgrade_1",
            p -> createFluidGenerator(p, "minecraft:milk", 50, 20));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_2 = ITEMS.registerItem("milk_generator_upgrade_2",
            p -> createFluidGenerator(p, "minecraft:milk", 250, 15));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_3 = ITEMS.registerItem("milk_generator_upgrade_3",
            p -> createFluidGenerator(p, "minecraft:milk", 1000, 10));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_4 = ITEMS.registerItem("milk_generator_upgrade_4",
            p -> createFluidGenerator(p, "minecraft:milk", 2500, 5));
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_5 = ITEMS.registerItem("milk_generator_upgrade_5",
            p -> createFluidGenerator(p, "minecraft:milk", 5000, 1));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}