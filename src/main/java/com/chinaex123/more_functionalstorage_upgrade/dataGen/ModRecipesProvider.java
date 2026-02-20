package com.chinaex123.more_functionalstorage_upgrade.dataGen;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.item.StorageUpgradeItem;
import com.buuz135.functionalstorage.util.StorageTags;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.ModItems;
import com.chinaex123.more_functionalstorage_upgrade.register.ModCompat.CreateCompat;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    // 获取物品
    private static Item getItem(String itemId) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemId));
    }

    // 获取流体
    private static Fluid getFluid(String fluidId) {
        return BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
    }

    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        // 锻造模板
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('B', Items.HEART_OF_THE_SEA)
                .define('C', Tags.Items.GEMS_AMETHYST)
                .define('D', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_generator_upgrade_smithing_template", has(Items.HEART_OF_THE_SEA))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("CBC")
                .pattern("CAC")
                .pattern("CCC")
                .define('A', Items.HEART_OF_THE_SEA)
                .define('B', ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE)
                .define('C', Tags.Items.GEMS_DIAMOND)
                .unlockedBy("has_generator_upgrade_smithing_template_2", has(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "generator_upgrade_smithing_template_2"));


        // ==================== 物品堆叠升级 ====================
        // 鳞甲升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get())
                .define('B', Tags.Items.CHESTS)
                .define('C', Items.TURTLE_SCUTE)
                .define('D', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_netherite_upgrade", has(FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get()))
                .save(recipeOutput);
        // 下界之星升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.NETHER_STAR_UPGRADE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get())
                .define('B', Tags.Items.CHESTS)
                .define('C', Items.NETHER_STAR)
                .define('D', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_turtle_scute_upgrade", has(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get()))
                .save(recipeOutput);
        // 重锤升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.HEAVY_CORE_UPGRADE.get())
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', CustomUpgradeItem.NETHER_STAR_UPGRADE.get())
                .define('B', Tags.Items.CHESTS)
                .define('C', Items.HEAVY_CORE)
                .define('D', Tags.Items.STORAGE_BLOCKS_DIAMOND)
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_obsidian_generator_upgrade_4", has(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "obsidian_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_cobblestone_generator_upgrade_4", has(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "cobblestone_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_dirt_generator_upgrade_4", has(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "dirt_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.SAND_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_sand_generator_upgrade_4", has(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "sand_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_andesite_generator_upgrade_4", has(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "andesite_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_diorite_generator_upgrade_4", has(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "diorite_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_granite_generator_upgrade_4", has(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "granite_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_cobbled_deepslate_generator_upgrade_4", has(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "cobbled_deepslate_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_blackstone_generator_upgrade_4", has(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "blackstone_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_netherrack_generator_upgrade_4", has(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "netherrack_generator_upgrade_5"));
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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_end_stone_generator_upgrade_4", has(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "end_stone_generator_upgrade_5"));
        // 凝灰岩生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_TUFF)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_tuff_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_tuff_generator_upgrade_1", has(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_tuff_generator_upgrade_2", has(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_tuff_generator_upgrade_3", has(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "tuff_generator_upgrade_4"));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_tuff_generator_upgrade_4", has(CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "tuff_generator_upgrade_5"));
        // 玄武岩生成生成升级
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get())
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', StorageTags.DRAWER)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Items.POLISHED_BASALT)
                .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                .unlockedBy("has_basalt_generator_upgrade", has(StorageTags.DRAWER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get())
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                .unlockedBy("has_basalt_generator_upgrade_1", has(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get())
                .define('B', Tags.Items.GEMS_DIAMOND)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .unlockedBy("has_basalt_generator_upgrade_2", has(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get()))
                .save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get()
                )
                .unlocks("has_basalt_generator_upgrade_3", has(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "basalt_generator_upgrade_4"));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_basalt_generator_upgrade_4", has(CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "basalt_generator_upgrade_5"));


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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.WATER_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_water_generator_upgrade_4", has(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "water_generator_upgrade_5"));

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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_lava_generator_upgrade_4", has(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "lava_generator_upgrade_5"));

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
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get()),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC, CustomUpgradeItem.MILK_GENERATOR_UPGRADE_5.get()
                )
                .unlocks("has_milk_generator_upgrade_5", has(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "milk_generator_upgrade_5"));



        // ==================== 兼容性升级 ====================

        // 机械动力
        if (ModList.get().isLoaded("create")) {
            // 锆蓝石生成升级
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.ASURINE_GENERATOR_UPGRADE_1.get())
                    .pattern("BDB")
                    .pattern("CAC")
                    .pattern("BDB")
                    .define('A', StorageTags.DRAWER)
                    .define('B', Tags.Items.INGOTS_IRON)
                    .define('C', getItem("create:polished_cut_asurine"))
                    .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                    .unlockedBy("has_asurine_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.ASURINE_GENERATOR_UPGRADE_2.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.ASURINE_GENERATOR_UPGRADE_1.get())
                    .define('B', Tags.Items.INGOTS_GOLD)
                    .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                    .unlockedBy("has_asurine_generator_upgrade_1", has(CreateCompat.ASURINE_GENERATOR_UPGRADE_1.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.ASURINE_GENERATOR_UPGRADE_3.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.ASURINE_GENERATOR_UPGRADE_2.get())
                    .define('B', Tags.Items.GEMS_DIAMOND)
                    .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                    .unlockedBy("has_asurine_generator_upgrade_2", has(CreateCompat.ASURINE_GENERATOR_UPGRADE_2.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.ASURINE_GENERATOR_UPGRADE_3.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC, CreateCompat.ASURINE_GENERATOR_UPGRADE_4.get()
                    )
                    .unlocks("has_asurine_generator_upgrade_3", has(CreateCompat.ASURINE_GENERATOR_UPGRADE_3.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "asurine_generator_upgrade_4"));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.ASURINE_GENERATOR_UPGRADE_4.get()),
                            Ingredient.of(Items.HEART_OF_THE_SEA),
                            RecipeCategory.MISC, CreateCompat.ASURINE_GENERATOR_UPGRADE_5.get()
                    )
                    .unlocks("has_asurine_generator_upgrade_5", has(CreateCompat.ASURINE_GENERATOR_UPGRADE_4.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "asurine_generator_upgrade_5"));
            // 绯红岩生成升级
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.CRIMSITE_GENERATOR_UPGRADE_1.get())
                    .pattern("BDB")
                    .pattern("CAC")
                    .pattern("BDB")
                    .define('A', StorageTags.DRAWER)
                    .define('B', Tags.Items.INGOTS_IRON)
                    .define('C', getItem("create:polished_cut_crimsite"))
                    .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                    .unlockedBy("has_crimsite_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.CRIMSITE_GENERATOR_UPGRADE_2.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.CRIMSITE_GENERATOR_UPGRADE_1.get())
                    .define('B', Tags.Items.INGOTS_GOLD)
                    .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                    .unlockedBy("has_crimsite_generator_upgrade_1", has(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_1.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.CRIMSITE_GENERATOR_UPGRADE_3.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.CRIMSITE_GENERATOR_UPGRADE_2.get())
                    .define('B', Tags.Items.GEMS_DIAMOND)
                    .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                    .unlockedBy("has_crimsite_generator_upgrade_2", has(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_2.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_3.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC, CreateCompat.CRIMSITE_GENERATOR_UPGRADE_4.get()
                    )
                    .unlocks("has_crimsite_generator_upgrade_3", has(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_3.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "crimsite_generator_upgrade_4"));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_4.get()),
                            Ingredient.of(Items.HEART_OF_THE_SEA),
                            RecipeCategory.MISC, CreateCompat.CRIMSITE_GENERATOR_UPGRADE_5.get()
                    )
                    .unlocks("has_crimsite_generator_upgrade_5", has(CreateCompat.CRIMSITE_GENERATOR_UPGRADE_4.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "crimsite_generator_upgrade_5"));
            // 赭金砂生成升级
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.OCHRUM_GENERATOR_UPGRADE_1.get())
                    .pattern("BDB")
                    .pattern("CAC")
                    .pattern("BDB")
                    .define('A', StorageTags.DRAWER)
                    .define('B', Tags.Items.INGOTS_IRON)
                    .define('C', getItem("create:polished_cut_ochrum"))
                    .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                    .unlockedBy("has_ochrum_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.OCHRUM_GENERATOR_UPGRADE_2.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.OCHRUM_GENERATOR_UPGRADE_1.get())
                    .define('B', Tags.Items.INGOTS_GOLD)
                    .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                    .unlockedBy("has_ochrum_generator_upgrade_1", has(CreateCompat.OCHRUM_GENERATOR_UPGRADE_1.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.OCHRUM_GENERATOR_UPGRADE_3.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.OCHRUM_GENERATOR_UPGRADE_2.get())
                    .define('B', Tags.Items.GEMS_DIAMOND)
                    .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                    .unlockedBy("has_ochrum_generator_upgrade_2", has(CreateCompat.OCHRUM_GENERATOR_UPGRADE_2.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.OCHRUM_GENERATOR_UPGRADE_3.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC, CreateCompat.OCHRUM_GENERATOR_UPGRADE_4.get()
                    )
                    .unlocks("has_ochrum_generator_upgrade_3", has(CreateCompat.OCHRUM_GENERATOR_UPGRADE_3.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "ochrum_generator_upgrade_4"));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.OCHRUM_GENERATOR_UPGRADE_4.get()),
                            Ingredient.of(Items.HEART_OF_THE_SEA),
                            RecipeCategory.MISC, CreateCompat.OCHRUM_GENERATOR_UPGRADE_5.get()
                    )
                    .unlocks("has_ochrum_generator_upgrade_5", has(CreateCompat.OCHRUM_GENERATOR_UPGRADE_4.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "ochrum_generator_upgrade_5"));
            // 赭金沙生成升级
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.VERIDIUM_GENERATOR_UPGRADE_1.get())
                    .pattern("BDB")
                    .pattern("CAC")
                    .pattern("BDB")
                    .define('A', StorageTags.DRAWER)
                    .define('B', Tags.Items.INGOTS_IRON)
                    .define('C', getItem("create:polished_cut_veridium"))
                    .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                    .unlockedBy("has_veridium_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.VERIDIUM_GENERATOR_UPGRADE_2.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.VERIDIUM_GENERATOR_UPGRADE_1.get())
                    .define('B', Tags.Items.INGOTS_GOLD)
                    .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                    .unlockedBy("has_veridium_generator_upgrade_1", has(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_1.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.VERIDIUM_GENERATOR_UPGRADE_3.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.VERIDIUM_GENERATOR_UPGRADE_2.get())
                    .define('B', Tags.Items.GEMS_DIAMOND)
                    .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                    .unlockedBy("has_veridium_generator_upgrade_2", has(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_2.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_3.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC, CreateCompat.VERIDIUM_GENERATOR_UPGRADE_4.get()
                    )
                    .unlocks("has_veridium_generator_upgrade_3", has(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_3.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "veridium_generator_upgrade_4"));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_4.get()),
                            Ingredient.of(Items.HEART_OF_THE_SEA),
                            RecipeCategory.MISC, CreateCompat.VERIDIUM_GENERATOR_UPGRADE_5.get()
                    )
                    .unlocks("has_veridium_generator_upgrade_5", has(CreateCompat.VERIDIUM_GENERATOR_UPGRADE_4.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "veridium_generator_upgrade_5"));
            // 石灰岩生成升级
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.LIMESTONE_GENERATOR_UPGRADE_1.get())
                    .pattern("BDB")
                    .pattern("CAC")
                    .pattern("BDB")
                    .define('A', StorageTags.DRAWER)
                    .define('B', Tags.Items.INGOTS_IRON)
                    .define('C', getItem("create:polished_cut_limestone"))
                    .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                    .unlockedBy("has_limestone_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.LIMESTONE_GENERATOR_UPGRADE_2.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.LIMESTONE_GENERATOR_UPGRADE_1.get())
                    .define('B', Tags.Items.INGOTS_GOLD)
                    .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                    .unlockedBy("has_limestone_generator_upgrade_1", has(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_1.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.LIMESTONE_GENERATOR_UPGRADE_3.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.LIMESTONE_GENERATOR_UPGRADE_2.get())
                    .define('B', Tags.Items.GEMS_DIAMOND)
                    .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                    .unlockedBy("has_limestone_generator_upgrade_2", has(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_2.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_3.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC, CreateCompat.LIMESTONE_GENERATOR_UPGRADE_4.get()
                    )
                    .unlocks("has_limestone_generator_upgrade_3", has(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_3.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "limestone_generator_upgrade_4"));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_4.get()),
                            Ingredient.of(Items.HEART_OF_THE_SEA),
                            RecipeCategory.MISC, CreateCompat.LIMESTONE_GENERATOR_UPGRADE_5.get()
                    )
                    .unlocks("has_limestone_generator_upgrade_5", has(CreateCompat.LIMESTONE_GENERATOR_UPGRADE_4.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "limestone_generator_upgrade_5"));

            // 蜂蜜生成升级
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.HONEY_GENERATOR_UPGRADE_1.get())
                    .pattern("BDB")
                    .pattern("EAC")
                    .pattern("BDB")
                    .define('A', StorageTags.DRAWER)
                    .define('B', Tags.Items.INGOTS_IRON)
                    .define('C', Items.HONEY_BOTTLE)
                    .define('D', Tags.Items.STORAGE_BLOCKS_IRON)
                    .define('E', Items.HONEYCOMB)
                    .unlockedBy("has_honey_generator_upgrade", has(FunctionalStorage.DRIPPING_UPGRADE.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.HONEY_GENERATOR_UPGRADE_2.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.HONEY_GENERATOR_UPGRADE_1.get())
                    .define('B', Tags.Items.INGOTS_GOLD)
                    .define('C', Tags.Items.STORAGE_BLOCKS_GOLD)
                    .unlockedBy("has_honey_generator_upgrade_1", has(CreateCompat.HONEY_GENERATOR_UPGRADE_1.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateCompat.HONEY_GENERATOR_UPGRADE_3.get())
                    .pattern("BCB")
                    .pattern("BAB")
                    .pattern("BCB")
                    .define('A', CreateCompat.HONEY_GENERATOR_UPGRADE_2.get())
                    .define('B', Tags.Items.GEMS_DIAMOND)
                    .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                    .unlockedBy("has_honey_generator_upgrade_2", has(CreateCompat.HONEY_GENERATOR_UPGRADE_2.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.HONEY_GENERATOR_UPGRADE_3.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC, CreateCompat.HONEY_GENERATOR_UPGRADE_4.get()
                    )
                    .unlocks("has_honey_generator_upgrade_3", has(CreateCompat.HONEY_GENERATOR_UPGRADE_3.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "honey_generator_upgrade_4"));
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(CreateCompat.HONEY_GENERATOR_UPGRADE_4.get()),
                            Ingredient.of(Items.HEART_OF_THE_SEA),
                            RecipeCategory.MISC, CreateCompat.HONEY_GENERATOR_UPGRADE_5.get()
                    )
                    .unlocks("has_honey_generator_upgrade_5", has(CreateCompat.HONEY_GENERATOR_UPGRADE_4.get()))
                    .save(recipeOutput.withConditions(modLoaded("create")),
                            ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "honey_generator_upgrade_5"));
        }
    }
}
