package com.chinaex123.more_functionalstorage_upgrade.data.recipes;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.data.recipes.integrations.ForbiddenArcanusRecipesProvider;
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
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import com.chinaex123.more_functionalstorage_upgrade.data.recipes.integrations.CreateRecipesProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * 模组配方数据生成器。
 * <p>
 * 继承自 RecipeProvider，负责在数据生成阶段产出本模组的全部配方。
 * 提供多套一级配方模板、分级升级配方与锻造升级配方的辅助方法，
 * 供具体配方生成逻辑复用。
 */
public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    /**
     * 构造配方数据生成器。
     *
     * @param output     数据包输出
     * @param registries 注册表提供者
     */
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    /**
     * 根据物品 ID 获取物品。
     *
     * @param itemId 物品 ID
     * @return 对应物品
     */
    public static Item getItem(String itemId) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemId));
    }

    /**
     * 根据流体 ID 获取流体。
     *
     * @param fluidId 流体 ID
     * @return 对应流体
     */
    public static Fluid getFluid(String fluidId) {
        return BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
    }

    /**
     * 生成基于标签的解锁条件。
     *
     * @param tag 物品标签
     * @return 解锁条件
     */
    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(
                ItemPredicate.Builder.item().of(tag).build());
    }

    /**
     * 生成基于具体物品的解锁条件。
     *
     * @param item 物品
     * @return 解锁条件
     */
    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(Item item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

    /**
     * 一级配方：BCB / BAB / BCB（center 为 Ingredient，unlockItem 为具体物品）。
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     */
    protected void tier1Recipe(RecipeOutput output,
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
     * 一级配方：BCB / BAB / BCB（center 为标签，解锁也用标签）。
     *
     * @param output 配方输出
     * @param result 配方结果物品
     * @param center 中心材料标签
     * @param b      材料 B
     * @param c      材料 C
     */
    protected void tier1Recipe(RecipeOutput output,
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
     * 一级配方：BDB / CAC / BDB（center 为 Ingredient，unlockItem 为具体物品）。
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     * @param d          材料 D
     */
    protected void tier1Recipe(RecipeOutput output,
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
     * 一级配方：BDB / CAC / BDB（center 为标签，解锁也用标签）。
     *
     * @param output 配方输出
     * @param result 配方结果物品
     * @param center 中心材料标签
     * @param b      材料 B
     * @param c      材料 C
     * @param d      材料 D
     */
    public void tier1Recipe(RecipeOutput output,
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
     * 一级配方：CDC / BAB / CDC（物品堆叠升级专用，center 为 Ingredient）。
     *
     * @param output     配方输出
     * @param result     配方结果物品
     * @param center     中心材料
     * @param unlockItem 解锁配方所需的物品
     * @param b          材料 B
     * @param c          材料 C
     * @param d          材料 D
     */
    protected void tier1RecipeCDC(RecipeOutput output,
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
     * 一级配方：BDB / EAC / BDB（蜂蜜专用）。
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
    public void tier1RecipeHoney(RecipeOutput output,
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
     * 二级/三级升级：BCB / BAB / BCB。
     *
     * @param output   配方输出
     * @param result   配方结果物品
     * @param previous 上一级升级物品
     * @param b        材料 B
     * @param c        材料 C
     */
    protected void tieredUpgrade(RecipeOutput output,
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
    protected void smithingTo4(RecipeOutput output,
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
     * 锻造升级至 5 级。
     * <p>
     * 使用本模组的生成器升级锻造模板、上一级升级物品与海洋之心进行锻造。
     *
     * @param output   配方输出
     * @param result   配方结果物品
     * @param previous 上一级升级物品
     * @param baseName 配方基础名称，用于生成注册 ID
     */
    protected void smithingTo5(RecipeOutput output,
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
    public void fullGeneratorUpgradeChain(RecipeOutput output,
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
        CustomUpgradeRecipesProvider.buildRecipes(this, recipeOutput);
        CreateRecipesProvider.buildRecipes(this, recipeOutput);
        ForbiddenArcanusRecipesProvider.buildRecipes(this, recipeOutput);
    }
}