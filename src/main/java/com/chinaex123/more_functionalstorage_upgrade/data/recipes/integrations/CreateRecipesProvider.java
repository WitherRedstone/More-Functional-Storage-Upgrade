package com.chinaex123.more_functionalstorage_upgrade.data.recipes.integrations;

import com.buuz135.functionalstorage.util.StorageTags;
import com.chinaex123.more_functionalstorage_upgrade.data.recipes.ModRecipesProvider;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.CreateUpgradeItem;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;

public class CreateRecipesProvider {

    public static void buildRecipes(ModRecipesProvider helper, RecipeOutput recipeOutput) {
        if (!ModList.get().isLoaded("create")) return;

        RecipeOutput createOutput = recipeOutput.withConditions(helper.modLoaded("create"));

        // 锆蓝石生成升级
        helper.tier1Recipe(createOutput,
                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_asurine")),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_5.get(),
                "asurine_generator_upgrade");
        // 绯红岩生成升级
        helper.tier1Recipe(createOutput,
                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_crimsite")),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_5.get(),
                "crimsite_generator_upgrade");
        // 赭金砂生成升级
        helper.tier1Recipe(createOutput,
                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_ochrum")),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_5.get(),
                "ochrum_generator_upgrade");
        // 辉绿岩生成升级
        helper.tier1Recipe(createOutput,
                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_veridium")),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_5.get(),
                "veridium_generator_upgrade");
        // 石灰岩生成升级
        helper.tier1Recipe(createOutput,
                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(ModRecipesProvider.getItem("create:polished_cut_limestone")),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_5.get(),
                "limestone_generator_upgrade");
        // 石灰岩生成升级
        helper.tier1Recipe(createOutput,
                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(ModRecipesProvider.getItem("create:scoria")),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.SCORIA_GENERATOR_UPGRADE_5.get(),
                "scoria_generator_upgrade");

        // 蜂蜜生成升级
        helper.tier1RecipeHoney(createOutput,
                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(StorageTags.DRAWER),
                Items.HONEYCOMB,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON),
                Ingredient.of(Items.HONEYCOMB));
        helper.fullGeneratorUpgradeChain(createOutput,
                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(),
                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_2.get(),
                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_3.get(),
                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_4.get(),
                CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_5.get(),
                "honey_generator_upgrade");
    }
}