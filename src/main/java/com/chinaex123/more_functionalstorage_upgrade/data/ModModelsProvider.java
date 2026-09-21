package com.chinaex123.more_functionalstorage_upgrade.data;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.init.ModItems;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.ForbiddenArcanusUpgradeItem;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Map;

public class ModModelsProvider extends ModelProvider {
    public ModModelsProvider(PackOutput output) {
        super(output, MoreFunctionalStorageUpgrade.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // ==================== 物品堆叠升级 ====================
        itemModels.generateFlatItem(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.NETHER_STAR_UPGRADE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.HEAVY_CORE_UPGRADE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // ==================== 物品功能升级 ====================

        // 黑曜石生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 圆石生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 沙砾生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 泥土生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 沙子生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 安山岩生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 闪长岩生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 花岗岩生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 深板岩圆石生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 黑石生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 下界岩生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 末地石生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 凝灰岩生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 玄武岩生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 滴水石块生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 海晶石生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 灵魂沙生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 幽匿块生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 黏土块生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // ==================== 流体功能升级 ====================

        // 水生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 滴水生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // 牛奶生成升级
        itemModels.generateFlatItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);


        // ==================== 兼容性升级 ====================
        // 机械动力
//        if (ModList.get().isLoaded("create")) {
//            // 锆蓝石生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            // 绯红岩生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            // 赭金砂生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            // 辉绿岩生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            // 石灰岩生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            // 熔渣生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//
//            // 蜂蜜生成升级
//            itemModels.generateFlatItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_2.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_3.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_4.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//            itemModels.generateFlatItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_5.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//        }

        // 禁忌与奥秘
        if (ModList.get().isLoaded("forbidden_arcanus")) {
            // 暗黑石生成升级
            ForbiddenArcanusItem(itemModels, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_1.get());
            ForbiddenArcanusItem(itemModels, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_2.get());
            ForbiddenArcanusItem(itemModels, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_3.get());
            ForbiddenArcanusItem(itemModels, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_4.get());
            ForbiddenArcanusItem(itemModels, ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_5.get());
        }


    }

//    /**
//     * 机械动力 联动物品模型（路径：textures/item/integrations/create）
//     */
//    private void CreateItem(DeferredItem<?> item) {
//        String itemName = item.getId().getPath();
//        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
//        builder.texture("layer0", MoreFunctionalStorageUpgrade.id("item/integrations/create/" + itemName));
//    }

    /**
     * 禁忌与奥秘 联动物品模型（路径：textures/item/integrations/forbidden_arcanus）
     */
    private static void ForbiddenArcanusItem(ItemModelGenerators itemModels, Item item) {
        String itemName = BuiltInRegistries.ITEM.getKey(item).getPath();
        Identifier textureId = MoreFunctionalStorageUpgrade.id("item/integrations/forbidden_arcanus/" + itemName);
        Material material = new Material(textureId);
        Identifier modelId = ModelTemplates.FLAT_HANDHELD_ITEM.create(
                item,
                TextureMapping.singleSlot(TextureSlot.LAYER0, material),
                itemModels.modelOutput
        );
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(modelId));
    }
}
