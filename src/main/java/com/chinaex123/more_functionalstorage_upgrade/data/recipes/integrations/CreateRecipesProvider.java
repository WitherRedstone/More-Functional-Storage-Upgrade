//package com.chinaex123.more_functionalstorage_upgrade.data.recipes.integrations;
//
//import com.buuz135.functionalstorage.util.StorageTags;
//import com.chinaex123.more_functionalstorage_upgrade.data.recipes.ModRecipesProvider;
//import com.chinaex123.more_functionalstorage_upgrade.init.integrations.CreateUpgradeItem;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.neoforged.fml.ModList;
//import net.neoforged.neoforge.common.Tags;
//
//public class CreateRecipesProvider {
//
//    public static void buildRecipes(ModRecipesProvider helper) {
//        if (!ModList.get().isLoaded("create")) return;
//
//        // 锆蓝石生成升级
//        helper.tier1Recipe(
//                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(),
//                StorageTags.DRAWER,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_asurine")),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_5.get(),
//                "asurine_generator_upgrade");
//        // 绯红岩生成升级
//        helper.tier1Recipe(
//                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(),
//                StorageTags.DRAWER,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_crimsite")),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_5.get(),
//                "crimsite_generator_upgrade");
//        // 赭金砂生成升级
//        helper.tier1Recipe(
//                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(),
//                StorageTags.DRAWER,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_ochrum")),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_5.get(),
//                "ochrum_generator_upgrade");
//        // 辉绿岩生成升级
//        helper.tier1Recipe(
//                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(),
//                StorageTags.DRAWER,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_veridium")),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_5.get(),
//                "veridium_generator_upgrade");
//        // 石灰岩生成升级
//        helper.tier1Recipe(
//                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(),
//                StorageTags.DRAWER,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_limestone")),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_5.get(),
//                "limestone_generator_upgrade");
//        // 熔渣生成升级
//        helper.tier1Recipe(
//                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1.get(),
//                StorageTags.DRAWER,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(ModRecipesProvider.getItem("create:scoria")),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_5.get(),
//                "scoria_generator_upgrade");
//
//        // 蜂蜜生成升级
//        helper.tier1RecipeHoney(
//                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(),
//                Ingredient.of(helper.getItemLookup().getOrThrow(StorageTags.DRAWER));
//                Items.HONEYCOMB,
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
//                Ingredient.of(Items.HONEY_BOTTLE),
//                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)),
//                Ingredient.of(Items.HONEYCOMB));
//        helper.fullGeneratorUpgradeChain(
//                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(),
//                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_2.get(),
//                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_3.get(),
//                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_4.get(),
//                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_5.get(),
//                "honey_generator_upgrade");
//    }
//}