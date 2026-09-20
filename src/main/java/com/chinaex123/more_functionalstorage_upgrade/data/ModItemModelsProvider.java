package com.chinaex123.more_functionalstorage_upgrade.data;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.CreateUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.init.ModItems;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.ForbiddenArcanusUpgradeItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

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
        // 沙砾生成升级
        basicItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_5.get());
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
        // 滴水石块生成升级
        basicItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_5.get());
        // 海晶石生成升级
        basicItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_5.get());
        // 灵魂沙生成升级
        basicItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_5.get());
        // 幽匿块生成升级
        basicItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_5.get());
        // 黏土块生成升级
        basicItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_1.get());
        basicItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_2.get());
        basicItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_3.get());
        basicItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_4.get());
        basicItem(CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_5.get());

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
        // 机械动力
        if (ModList.get().isLoaded("create")) {
            // 锆蓝石生成升级
            CreateItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_5);
            // 绯红岩生成升级
            CreateItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_5);
            // 赭金砂生成升级
            CreateItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_5);
            // 辉绿岩生成升级
            CreateItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_5);
            // 石灰岩生成升级
            CreateItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_5);
            // 熔渣生成升级
            CreateItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_5);

            // 蜂蜜生成升级
            CreateItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1);
            CreateItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_2);
            CreateItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_3);
            CreateItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_4);
            CreateItem(CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_5);
        }

        // 禁忌与奥秘
        if (ModList.get().isLoaded("forbidden_arcanus")) {
            // 暗黑石生成升级
            ForbiddenArcanusItem(ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_1);
            ForbiddenArcanusItem(ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_2);
            ForbiddenArcanusItem(ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_3);
            ForbiddenArcanusItem(ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_4);
            ForbiddenArcanusItem(ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_5);
        }


    }

    /**
     * 机械动力 联动物品模型（路径：textures/item/integrations/create）
     */
    private void CreateItem(DeferredItem<?> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", MoreFunctionalStorageUpgrade.id("item/integrations/create/" + itemName));
    }

    /**
     * 禁忌与奥秘 联动物品模型（路径：textures/item/integrations/forbidden_arcanus）
     */
    private void ForbiddenArcanusItem(DeferredItem<?> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", MoreFunctionalStorageUpgrade.id("item/integrations/forbidden_arcanus/" + itemName));
    }
}
