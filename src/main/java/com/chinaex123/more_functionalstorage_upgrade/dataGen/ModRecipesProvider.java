package com.chinaex123.more_functionalstorage_upgrade.dataGen;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.item.StorageUpgradeItem;
import com.buuz135.functionalstorage.util.StorageTags;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.CustomUpgradeItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        // ==================== 物品堆叠升级 ====================
        // 鳞甲升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get())
                .define('B', Blocks.CHEST)
                .define('C', Items.TURTLE_SCUTE)
                .define('D', Blocks.DIAMOND_BLOCK)
                .unlockedBy("has_netherite_upgrade", has(FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get()))
                .save(recipeOutput);
        // 下界之星升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.NETHER_STAR_UPGRADE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get())
                .define('B', Blocks.CHEST)
                .define('C', Items.NETHER_STAR)
                .define('D', Blocks.DIAMOND_BLOCK)
                .unlockedBy("has_turtle_scute_upgrade", has(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get()))
                .save(recipeOutput);
        // 重锤升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.HEAVY_CORE_UPGRADE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', CustomUpgradeItem.NETHER_STAR_UPGRADE.get())
                .define('B', Blocks.CHEST)
                .define('C', Blocks.HEAVY_CORE)
                .define('D', Blocks.DIAMOND_BLOCK)
                .unlockedBy("has_nether_star_upgrade", has(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()))
                .save(recipeOutput);


        // ==================== 物品功能升级 ====================
        // 黑曜石生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', FunctionalStorage.OBSIDIAN_UPGRADE.get())
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_obsidian_generator_upgrade", has(FunctionalStorage.OBSIDIAN_UPGRADE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_obsidian_generator_upgrade_1", has(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_obsidian_generator_upgrade_2", has(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_obsidian_generator_upgrade_3", has(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "obsidian_generator_upgrade_4"));

        // 圆石生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get())
                .pattern("BEB")
                .pattern("CAD")
                .pattern("BEB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.WATER_BUCKET)
                .define('D', Items.LAVA_BUCKET)
                .define('E', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_cobblestone_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_cobblestone_generator_upgrade_1", has(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_cobblestone_generator_upgrade_2", has(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_cobblestone_generator_upgrade_3", has(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "cobblestone_generator_upgrade_4"));

        // 泥土生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.ROOTED_DIRT)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_dirt_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_dirt_generator_upgrade_1", has(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_dirt_generator_upgrade_2", has(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_dirt_generator_upgrade_3", has(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "dirt_generator_upgrade_4"));

        // 沙子生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.QUARTZ)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_sand_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_sand_generator_upgrade_1", has(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_sand_generator_upgrade_2", has(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_sand_generator_upgrade_3", has(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "sand_generator_upgrade_4"));

        // 安山岩生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_ANDESITE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_andesite_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_andesite_generator_upgrade_1", has(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_andesite_generator_upgrade_2", has(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_andesite_generator_upgrade_3", has(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "andesite_generator_upgrade_4"));

        // 闪长岩生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_DIORITE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_diorite_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_diorite_generator_upgrade_1", has(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_diorite_generator_upgrade_2", has(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_diorite_generator_upgrade_3", has(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "diorite_generator_upgrade_4"));

        // 花岗岩生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_GRANITE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_granite_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_granite_generator_upgrade_1", has(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_granite_generator_upgrade_2", has(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_granite_generator_upgrade_3", has(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "granite_generator_upgrade_4"));

        // 深板岩圆石生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_DEEPSLATE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_cobbled_deepslate_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_cobbled_deepslate_generator_upgrade_1", has(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_cobbled_deepslate_generator_upgrade_2", has(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_cobbled_deepslate_generator_upgrade_3", has(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "cobbled_deepslate_generator_upgrade_4"));

        // 黑石生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_DEEPSLATE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_blackstone_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_blackstone_generator_upgrade_1", has(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_blackstone_generator_upgrade_2", has(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_blackstone_generator_upgrade_3", has(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "blackstone_generator_upgrade_4"));

        // 黑石生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_DEEPSLATE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_netherrack_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_netherrack_generator_upgrade_1", has(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_netherrack_generator_upgrade_2", has(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_netherrack_generator_upgrade_3", has(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "netherrack_generator_upgrade_4"));

        // 末地石生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_DEEPSLATE)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_end_stone_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_end_stone_generator_upgrade_1", has(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_end_stone_generator_upgrade_2", has(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_end_stone_generator_upgrade_3", has(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "end_stone_generator_upgrade_4"));


        // ==================== 流体功能升级 ====================
        // 水生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', FunctionalStorage.WATER_GENERATOR_UPGRADE.get())
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_water_generator_upgrade", has(FunctionalStorage.WATER_GENERATOR_UPGRADE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_water_generator_upgrade_1", has(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_water_generator_upgrade_2", has(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_water_generator_upgrade_3", has(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "water_generator_upgrade_4"));

        // 滴水生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', FunctionalStorage.DRIPPING_UPGRADE.get())
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_lava_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_lava_generator_upgrade_1", has(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_lava_generator_upgrade_2", has(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_lava_generator_upgrade_3", has(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "lava_generator_upgrade_4"));

        // 牛奶生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.MILK_BUCKET)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_milk_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_milk_generator_upgrade_1", has(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_milk_generator_upgrade_2", has(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_milk_generator_upgrade_3", has(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "milk_generator_upgrade_4"));
    }
}
