package com.chinaex123.more_functionalstorage_upgrade.data;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.item.StorageUpgradeItem;
import com.buuz135.functionalstorage.util.StorageTags;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.init.integrations.CreateUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.init.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
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

    private static Item getItem(String itemId) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemId));
    }

    private static Fluid getFluid(String fluidId) {
        return BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
    }

    /**
     * 检查物品标签
     */
    protected static Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(
                ItemPredicate.Builder.item().of(tag).build());
    }

    /**
     * 检查具体物品
     */
    protected static Criterion<InventoryChangeTrigger.TriggerInstance> has(Item item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

    /**
     * 一级配方：BCB / BAB / BCB
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     */
    private void tier1Recipe(RecipeOutput output,
                             Item result,
                             Ingredient center,
                             ItemLike unlockItem,
                             Ingredient b,
                             Ingredient c) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', center)
                .define('B', b)
                .define('C', c)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }

    /**
     * 一级配方：BCB / BAB / BCB
     *
     * @param output 配方输出
     * @param result 配方结果物品
     * @param center 中心材料标签
     * @param b      材料 B
     * @param c      材料 C
     */
    private void tier1Recipe(RecipeOutput output,
                             Item result,
                             TagKey<Item> center,
                             Ingredient b,
                             Ingredient c) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', center)
                .define('B', b)
                .define('C', c)
                .unlockedBy("has_" + center.location().getPath(), has(center))
                .save(output);
    }

    /**
     * 一级配方：BDB / CAC / BDB
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     * @param d          材料 D
     */
    private void tier1Recipe(RecipeOutput output,
                             Item result,
                             Ingredient center,
                             ItemLike unlockItem,
                             Ingredient b,
                             Ingredient c,
                             Ingredient d) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', center)
                .define('B', b)
                .define('C', c)
                .define('D', d)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }

    /**
     * 一级配方：BDB / CAC / BDB
     *
     * @param output 配方输出
     * @param result 配方结果物品
     * @param center 中心材料标签
     * @param b      材料 B
     * @param c      材料 C
     * @param d      材料 D
     */
    private void tier1Recipe(RecipeOutput output,
                             Item result,
                             TagKey<Item> center,
                             Ingredient b,
                             Ingredient c,
                             Ingredient d) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("BDB")
                .pattern("CAC")
                .pattern("BDB")
                .define('A', center)
                .define('B', b)
                .define('C', c)
                .define('D', d)
                .unlockedBy("has_" + center.location().getPath(), has(center))
                .save(output);
    }

    /**
     * 一级配方：CDC / BAB / CDC
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     * @param d          材料 D
     */
    private void tier1RecipeCDC(RecipeOutput output,
                                Item result,
                                Ingredient center,
                                ItemLike unlockItem,
                                Ingredient b,
                                Ingredient c,
                                Ingredient d) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("CDC")
                .pattern("BAB")
                .pattern("CDC")
                .define('A', center)
                .define('B', b)
                .define('C', c)
                .define('D', d)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }

    /**
     * 一级配方：BDB / EAC / BDB
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     * @param d          材料 D
     * @param e          材料 E
     */
    private void tier1RecipeHoney(RecipeOutput output,
                                  Item result,
                                  Ingredient center,
                                  ItemLike unlockItem,
                                  Ingredient b,
                                  Ingredient c,
                                  Ingredient d,
                                  Ingredient e) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("BDB")
                .pattern("EAC")
                .pattern("BDB")
                .define('A', center)
                .define('B', b)
                .define('C', c)
                .define('D', d)
                .define('E', e)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }

    /**
     * 二级/三级升级：BCB / BAB / BCB
     *
     * @param output   配方输出
     * @param result   配方结果物品
     * @param previous 上一级升级物品
     * @param b        材料 B
     * @param c        材料 C
     */
    private void tieredUpgrade(RecipeOutput output,
                               Item result,
                               Item previous,
                               Ingredient b,
                               Ingredient c) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("BCB")
                .pattern("BAB")
                .pattern("BCB")
                .define('A', previous)
                .define('B', b)
                .define('C', c)
                .unlockedBy(getHasName(previous), has(previous))
                .save(output);
    }

    /**
     * 锻造升级至 4 级。
     * <p>
     * 使用下界合金升级模板、上一级升级物品与下界合金锭进行锻造。
     *
     * @param output   配方输出
     * @param result   配方结果物品
     * @param previous 上一级升级物品
     * @param baseName 配方基础名称，用于生成注册 ID
     */
    private void smithingTo4(RecipeOutput output,
                             Item result,
                             Item previous,
                             String baseName) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(previous),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC,
                        result
                )
                .unlocks("has_" + baseName + "_3", has(previous))
                .save(output, ResourceLocation.fromNamespaceAndPath(
                        MoreFunctionalStorageUpgrade.MOD_ID,
                        baseName + "_4"));
    }

    /**
     * 锻造升级至 5 级
     *
     * @param output   配方输出
     * @param result   配方结果物品
     * @param previous 上一级升级物品
     * @param baseName 配方基础名称，用于生成注册 ID
     */
    private void smithingTo5(RecipeOutput output,
                             Item result,
                             Item previous,
                             String baseName) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.GENERATOR_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(previous),
                        Ingredient.of(Items.HEART_OF_THE_SEA),
                        RecipeCategory.MISC,
                        result
                )
                .unlocks("has_" + baseName + "_4", has(previous))
                .save(output, ResourceLocation.fromNamespaceAndPath(
                        MoreFunctionalStorageUpgrade.MOD_ID,
                        baseName + "_5"));
    }

    /**
     * 生成完整的生成器升级链（1 级至 5 级）。
     * <p>
     * 2 级与 3 级使用工作台配方（金 → 钻石），
     * 4 级与 5 级使用锻造台配方。
     *
     * @param output   配方输出
     * @param upgrade1 1 级升级物品
     * @param upgrade2 2 级升级物品
     * @param upgrade3 3 级升级物品
     * @param upgrade4 4 级升级物品
     * @param upgrade5 5 级升级物品
     * @param baseName 配方基础名称，用于生成注册 ID
     */
    private void fullGeneratorUpgradeChain(RecipeOutput output,
                                           Item upgrade1,
                                           Item upgrade2,
                                           Item upgrade3,
                                           Item upgrade4,
                                           Item upgrade5,
                                           String baseName) {
        // 2 级：金锭 + 金块
        tieredUpgrade(output, upgrade2, upgrade1,
                Ingredient.of(Tags.Items.INGOTS_GOLD),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD));

        // 3 级：钻石 + 钻石块
        tieredUpgrade(output, upgrade3, upgrade2,
                Ingredient.of(Tags.Items.GEMS_DIAMOND),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND));

        // 4 级与 5 级：锻造台配方
        smithingTo4(output, upgrade4, upgrade3, baseName);
        smithingTo5(output, upgrade5, upgrade4, baseName);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        // ==================== 锻造模板 ====================
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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        MoreFunctionalStorageUpgrade.MOD_ID, "generator_upgrade_smithing_template_2"));

        // ==================== 物品堆叠升级 ====================

        // 鳞甲升级
        tier1RecipeCDC(recipeOutput,
                CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get(),
                Ingredient.of(FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get()),
                FunctionalStorage.STORAGE_UPGRADES.get(StorageUpgradeItem.StorageTier.NETHERITE).get(),
                Ingredient.of(Tags.Items.CHESTS),
                Ingredient.of(Items.TURTLE_SCUTE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND));

        // 下界之星升级
        tier1RecipeCDC(recipeOutput,
                CustomUpgradeItem.NETHER_STAR_UPGRADE.get(),
                Ingredient.of(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get()),
                CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get(),
                Ingredient.of(Tags.Items.CHESTS),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND));

        // 重锤升级
        tier1RecipeCDC(recipeOutput,
                CustomUpgradeItem.HEAVY_CORE_UPGRADE.get(),
                Ingredient.of(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()),
                CustomUpgradeItem.NETHER_STAR_UPGRADE.get(),
                Ingredient.of(Tags.Items.CHESTS),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND));

        // ==================== 物品功能升级 ====================

        // ---- 黑曜石 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(FunctionalStorage.OBSIDIAN_UPGRADE.get()),
                FunctionalStorage.OBSIDIAN_UPGRADE.get(),
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_5.get(),
                "obsidian_generator_upgrade");

        // ---- 圆石 ----
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
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_5.get(),
                "cobblestone_generator_upgrade");

        // ---- 泥土 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.ROOTED_DIRT),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_5.get(),
                "dirt_generator_upgrade");

        // ---- 沙子 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Tags.Items.SANDS),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.SAND_GENERATOR_UPGRADE_5.get(),
                "sand_generator_upgrade");

        // ---- 安山岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_ANDESITE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_5.get(),
                "andesite_generator_upgrade");

        // ---- 闪长岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_DIORITE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_5.get(),
                "diorite_generator_upgrade");

        // ---- 花岗岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_GRANITE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_5.get(),
                "granite_generator_upgrade");

        // ---- 深板岩圆石 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_DEEPSLATE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5.get(),
                "cobbled_deepslate_generator_upgrade");

        // ---- 黑石 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_BLACKSTONE),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_5.get(),
                "blackstone_generator_upgrade");

        // ---- 下界岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.NETHERRACK),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_5.get(),
                "netherrack_generator_upgrade");

        // ---- 末地石 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.END_STONE_BRICKS),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_5.get(),
                "end_stone_generator_upgrade");

        // ---- 凝灰岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_TUFF),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.TUFF_GENERATOR_UPGRADE_5.get(),
                "tuff_generator_upgrade");

        // ---- 玄武岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.POLISHED_BASALT),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.BASALT_GENERATOR_UPGRADE_5.get(),
                "basalt_generator_upgrade");

        // ==================== 流体功能升级 ====================

        // ---- 水 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(FunctionalStorage.WATER_GENERATOR_UPGRADE.get()),
                FunctionalStorage.WATER_GENERATOR_UPGRADE.get(),
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.WATER_GENERATOR_UPGRADE_5.get(),
                "water_generator_upgrade");

        // ---- 熔岩 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get(),
                Ingredient.of(FunctionalStorage.DRIPPING_UPGRADE.get()),
                FunctionalStorage.DRIPPING_UPGRADE.get(),
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_5.get(),
                "lava_generator_upgrade");

        // ---- 牛奶 ----
        tier1Recipe(recipeOutput,
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get(),
                StorageTags.DRAWER,
                Ingredient.of(Tags.Items.INGOTS_IRON),
                Ingredient.of(Items.MILK_BUCKET),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
        fullGeneratorUpgradeChain(recipeOutput,
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get(),
                CustomUpgradeItem.MILK_GENERATOR_UPGRADE_5.get(),
                "milk_generator_upgrade");

        // ==================== Create 兼容 ====================
        if (ModList.get().isLoaded("create")) {
            RecipeOutput createOutput = recipeOutput.withConditions(modLoaded("create"));

            // 锆蓝石
            tier1Recipe(createOutput,
                    CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(),
                    StorageTags.DRAWER,
                    Ingredient.of(Tags.Items.INGOTS_IRON),
                    Ingredient.of(getItem("create:polished_cut_asurine")),
                    Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
            fullGeneratorUpgradeChain(createOutput,
                    CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_1.get(),
                    CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_2.get(),
                    CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_3.get(),
                    CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_4.get(),
                    CreateUpgradeItem.ASURINE_GENERATOR_UPGRADE_5.get(),
                    "asurine_generator_upgrade");

            // 绯红岩
            tier1Recipe(createOutput,
                    CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(),
                    StorageTags.DRAWER,
                    Ingredient.of(Tags.Items.INGOTS_IRON),
                    Ingredient.of(getItem("create:polished_cut_crimsite")),
                    Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
            fullGeneratorUpgradeChain(createOutput,
                    CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_1.get(),
                    CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_2.get(),
                    CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_3.get(),
                    CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_4.get(),
                    CreateUpgradeItem.CRIMSITE_GENERATOR_UPGRADE_5.get(),
                    "crimsite_generator_upgrade");

            // 赭金砂
            tier1Recipe(createOutput,
                    CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(),
                    StorageTags.DRAWER,
                    Ingredient.of(Tags.Items.INGOTS_IRON),
                    Ingredient.of(getItem("create:polished_cut_ochrum")),
                    Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
            fullGeneratorUpgradeChain(createOutput,
                    CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_1.get(),
                    CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_2.get(),
                    CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_3.get(),
                    CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_4.get(),
                    CreateUpgradeItem.OCHRUM_GENERATOR_UPGRADE_5.get(),
                    "ochrum_generator_upgrade");

            // 赭金沙（Veridium）
            tier1Recipe(createOutput,
                    CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(),
                    StorageTags.DRAWER,
                    Ingredient.of(Tags.Items.INGOTS_IRON),
                    Ingredient.of(getItem("create:polished_cut_veridium")),
                    Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
            fullGeneratorUpgradeChain(createOutput,
                    CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_1.get(),
                    CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_2.get(),
                    CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_3.get(),
                    CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_4.get(),
                    CreateUpgradeItem.VERIDIUM_GENERATOR_UPGRADE_5.get(),
                    "veridium_generator_upgrade");

            // 石灰岩
            tier1Recipe(createOutput,
                    CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(),
                    StorageTags.DRAWER,
                    Ingredient.of(Tags.Items.INGOTS_IRON),
                    Ingredient.of(getItem("create:polished_cut_limestone")),
                    Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON));
            fullGeneratorUpgradeChain(createOutput,
                    CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_1.get(),
                    CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_2.get(),
                    CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_3.get(),
                    CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_4.get(),
                    CreateUpgradeItem.LIMESTONE_GENERATOR_UPGRADE_5.get(),
                    "limestone_generator_upgrade");

            // 蜂蜜（BDB / EAC / BDB）
            tier1RecipeHoney(createOutput,
                    CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(),
                    Ingredient.of(StorageTags.DRAWER),
                    Items.HONEYCOMB,
                    Ingredient.of(Tags.Items.INGOTS_IRON),
                    Ingredient.of(Items.HONEY_BOTTLE),
                    Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON),
                    Ingredient.of(Items.HONEYCOMB));
            fullGeneratorUpgradeChain(createOutput,
                    CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_1.get(),
                    CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_2.get(),
                    CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_3.get(),
                    CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_4.get(),
                    CreateUpgradeItem.HONEY_GENERATOR_UPGRADE_5.get(),
                    "honey_generator_upgrade");
        }
    }
}