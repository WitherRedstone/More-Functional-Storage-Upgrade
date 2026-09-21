package com.chinaex123.more_functionalstorage_upgrade.data.recipes;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.item.StorageUpgradeItem;
import com.buuz135.functionalstorage.util.StorageTags;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.init.ModItems;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

public class CustomUpgradeRecipesProvider {

    public static void buildRecipes(ModRecipesProvider helper) {

        // ==================== 锻造模板 ====================
        // 海洋之心锻造模板
        ShapedRecipeBuilder.shaped(helper.getItemLookup(), RecipeCategory.MISC, ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('B', Items.HEART_OF_THE_SEA)
                .define('C', Tags.Items.GEMS_AMETHYST)
                .define('D', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_generator_upgrade_smithing_template", helper.has(Items.HEART_OF_THE_SEA))
                .save(helper.getOutput());
        ShapedRecipeBuilder.shaped(helper.getItemLookup(), RecipeCategory.MISC, ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("CBC")
                .pattern("CAC")
                .pattern("CCC")
                .define('A', Items.HEART_OF_THE_SEA)
                .define('B', ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE)
                .define('C', Tags.Items.GEMS_DIAMOND)
                .unlockedBy("has_generator_upgrade_smithing_template_2", helper.has(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(helper.getOutput(), String.valueOf(Identifier.fromNamespaceAndPath(
                        MoreFunctionalStorageUpgrade.MOD_ID, "generator_upgrade_smithing_template_2")));

        // ==================== 物品堆叠升级 ====================

        // 海龟鳞片升级
        helper.tier1RecipeCDC(
                CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get(),
                Ingredient.of(FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get()),
                FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get(),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.CHESTS)),
                Ingredient.of(Items.TURTLE_SCUTE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_DIAMOND)));
        // 下界之星升级
        helper.tier1RecipeCDC(
                CustomUpgradeItem.NETHER_STAR_UPGRADE.get(),
                Ingredient.of(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get()),
                CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get(),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.CHESTS)),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_DIAMOND)));
        // 重锤升级
        helper.tier1RecipeCDC(
                CustomUpgradeItem.HEAVY_CORE_UPGRADE.get(),
                Ingredient.of(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()),
                CustomUpgradeItem.NETHER_STAR_UPGRADE.get(),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.CHESTS)),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_DIAMOND)));

        // ==================== 物品功能升级 ====================

        // 黑曜石生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(FunctionalStorage.OBSIDIAN_UPGRADE.get()),
                FunctionalStorage.OBSIDIAN_UPGRADE.get(),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_5.get(),
                "obsidian_generator_upgrade");
        // 圆石生成升级
        ShapedRecipeBuilder.shaped(helper.getItemLookup(), RecipeCategory.MISC, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get())
                .pattern("BEB")
                .pattern("CAD")
                .pattern("BEB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.WATER_BUCKET)
                .define('D', Items.LAVA_BUCKET)
                .define('E', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_cobblestone_generator_upgrade", helper.has(StorageTags.DRAWER))
                .save(helper.getOutput());
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_5.get(),
                "cobblestone_generator_upgrade");
        // 沙砾生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.GRAVEL),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.GRAVEL_GENERATOR_UPGRADE_5.get(),
                "gravel_generator_upgrade");
        // 泥土生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.ROOTED_DIRT),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_5.get(),
                "dirt_generator_upgrade");
        // 沙子生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.SANDS)),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_5.get(),
                "sand_generator_upgrade");
        // 安山岩生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_ANDESITE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_5.get(),
                "andesite_generator_upgrade");
        // 闪长岩生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_DIORITE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_5.get(),
                "diorite_generator_upgrade");
        // 花岗岩生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_GRANITE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_5.get(),
                "granite_generator_upgrade");
        // 深板岩圆石生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_DEEPSLATE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5.get(),
                "cobbled_deepslate_generator_upgrade");
        // 黑石生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_BLACKSTONE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_5.get(),
                "blackstone_generator_upgrade");
        // 下界岩生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.NETHERRACK),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_5.get(),
                "netherrack_generator_upgrade");
        // 末地石生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.END_STONE_BRICKS),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_5.get(),
                "end_stone_generator_upgrade");
        // 凝灰岩生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_TUFF),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_5.get(),
                "tuff_generator_upgrade");
        // 玄武岩生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POLISHED_BASALT),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_5.get(),
                "basalt_generator_upgrade");
        // 滴水石块生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.POINTED_DRIPSTONE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.DRIPSTONE_GENERATOR_UPGRADE_5.get(),
                "dripstone_generator_upgrade");
        // 海晶石生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.PRISMARINE),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.PRISMARINE_GENERATOR_UPGRADE_5.get(),
                "prismarine_generator_upgrade");
        // 灵魂沙生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.SOUL_SAND),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.SOUL_SAND_GENERATOR_UPGRADE_5.get(),
                "soul_sand_generator_upgrade");
        // 幽匿块生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.SCULK),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.SCULK_GENERATOR_UPGRADE_5.get(),
                "sculk_generator_upgrade");
        // 黏土块生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.CLAY),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.CLAY_GENERATOR_UPGRADE_5.get(),
                "clay_generator_upgrade");

        // ==================== 流体功能升级 ====================

        // 水生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(FunctionalStorage.WATER_GENERATOR_UPGRADE.get()),
                FunctionalStorage.WATER_GENERATOR_UPGRADE.get(),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_5.get(),
                "water_generator_upgrade");
        // 岩浆生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(FunctionalStorage.DRIPPING_UPGRADE.get()),
                FunctionalStorage.DRIPPING_UPGRADE.get(),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_5.get(),
                "lava_generator_upgrade");
        // 牛奶生成升级
        helper.tier1Recipe(
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.INGOTS_IRON)),
                Ingredient.of(Items.MILK_BUCKET),
                Ingredient.of(helper.getItemLookup().getOrThrow(Tags.Items.STORAGE_BLOCKS_IRON)));
        helper.fullGeneratorUpgradeChain(
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_5.get(),
                "milk_generator_upgrade");
    }
}