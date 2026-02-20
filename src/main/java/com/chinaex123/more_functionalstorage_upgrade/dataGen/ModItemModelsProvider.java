package com.chinaex123.more_functionalstorage_upgrade.dataGen;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.ModItems;
import com.chinaex123.more_functionalstorage_upgrade.register.ModCompat.CreateCompat;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoreFunctionalStorageUpgrade.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get());

        // ==================== 物品堆叠升级 ====================
        basicItem(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get());
        basicItem(CustomUpgradeItem.NETHER_STAR_UPGRADE.get());
        basicItem(CustomUpgradeItem.HEAVY_CORE_UPGRADE.get());

        // ==================== 物品功能升级 ====================
        // 黑曜石生成升级
        basicItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_5.get());
        // 圆石生成升级
        basicItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_5.get());
        // 泥土生成升级
        basicItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_5.get());
        // 沙子生成升级
        basicItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_5.get());
        // 安山岩生成升级
        basicItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_5.get());
        // 闪长岩生成升级
        basicItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_5.get());
        // 花岗岩生成升级
        basicItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_5.get());
        // 深板岩圆石生成升级
        basicItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5.get());
        // 黑石生成升级
        basicItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_5.get());
        // 下界岩生成升级
        basicItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_5.get());
        // 末地石生成升级
        basicItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_5.get());
        // 凝灰岩生成升级
        basicItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_5.get());
        // 玄武岩生成升级
        basicItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_5.get());


        // ==================== 流体功能升级 ====================
        // 水生成升级
        basicItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_5.get());
        // 滴水生成升级
        basicItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_5.get());
        // 牛奶生成升级
        basicItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_5.get());


        // ==================== 兼容性升级 ====================
        // 只有当 Create 模组加载时才生成相关物品模型
        if (ModList.get().isLoaded("create")) {
            // 锆蓝石生成升级
            basicItem(CreateCompat.ASURINE_GENERATOR_UPGRADE_1.get());
            basicItem(CreateCompat.ASURINE_GENERATOR_UPGRADE_2.get());
            basicItem(CreateCompat.ASURINE_GENERATOR_UPGRADE_3.get());
            basicItem(CreateCompat.ASURINE_GENERATOR_UPGRADE_4.get());
            basicItem(CreateCompat.ASURINE_GENERATOR_UPGRADE_5.get());
            // 绯红岩生成升级
            basicItem(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_1.get());
            basicItem(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_2.get());
            basicItem(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_3.get());
            basicItem(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_4.get());
            basicItem(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_5.get());
            // 赭金砂生成升级
            basicItem(CreateCompat.OCHRUM_GENERATOR_UPGRADE_1.get());
            basicItem(CreateCompat.OCHRUM_GENERATOR_UPGRADE_2.get());
            basicItem(CreateCompat.OCHRUM_GENERATOR_UPGRADE_3.get());
            basicItem(CreateCompat.OCHRUM_GENERATOR_UPGRADE_4.get());
            basicItem(CreateCompat.OCHRUM_GENERATOR_UPGRADE_5.get());
            // 辉绿岩生成升级
            basicItem(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_1.get());
            basicItem(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_2.get());
            basicItem(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_3.get());
            basicItem(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_4.get());
            basicItem(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_5.get());
            // 石灰岩生成升级
            basicItem(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_1.get());
            basicItem(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_2.get());
            basicItem(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_3.get());
            basicItem(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_4.get());
            basicItem(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_5.get());
            // 蜂蜜生成升级
            basicItem(CreateCompat.HONEY_GENERATOR_UPGRADE_1.get());
            basicItem(CreateCompat.HONEY_GENERATOR_UPGRADE_2.get());
            basicItem(CreateCompat.HONEY_GENERATOR_UPGRADE_3.get());
            basicItem(CreateCompat.HONEY_GENERATOR_UPGRADE_4.get());
            basicItem(CreateCompat.HONEY_GENERATOR_UPGRADE_5.get());
        }
    }
}
