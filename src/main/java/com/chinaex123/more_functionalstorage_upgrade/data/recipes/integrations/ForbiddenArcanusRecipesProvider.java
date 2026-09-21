package com.chinaex123.more_functionalstorage_upgrade.data.recipes.integrations;

import com.buuz135.functionalstorage.util.StorageTags;
import com.chinaex123.more_functionalstorage_upgrade.data.recipes.ModRecipesProvider;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.ForbiddenArcanusUpgradeItem;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;

public class ForbiddenArcanusRecipesProvider {

    public static void buildRecipes(ModRecipesProvider helper) {
        if (!ModList.get().isLoaded("forbidden_arcanus")) return;

        // 暗黑石生成升级
        helper.tier1Recipe(
                ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(ModRecipesProvider.getItem("forbidden_arcanus:darkstone")),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_1.get(),
                ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_2.get(),
                ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_3.get(),
                ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_4.get(),
                ForbiddenArcanusUpgradeItem.DARKSTONE_GENERATOR_UPGRADE_5.get(),
                "darkstone_generator_upgrade");
    }
}