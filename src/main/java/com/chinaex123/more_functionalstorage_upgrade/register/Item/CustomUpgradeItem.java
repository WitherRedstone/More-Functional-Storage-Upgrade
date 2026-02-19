package com.chinaex123.more_functionalstorage_upgrade.register.Item;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.register.Fluid.ConfigFluidGeneration;
import com.chinaex123.more_functionalstorage_upgrade.register.MoreUpgradeItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CustomUpgradeItem {
    // 创建物品注册器 - 使用正确的工厂方法
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MoreFunctionalStorageUpgrade.MOD_ID);

    // ================= 物品生成工厂方法 =================
    /**
     * 创建物品生成器升级
     * @param itemToGenerate 要生成的物品和数量
     * @param generationRate 每次生成的数量
     * @param interval 生成间隔（刻），也用作ConfigItemGeneration的第三个参数
     */
    private static Item createItemGenerator(ItemStack itemToGenerate, int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigItemGeneration(
                        itemToGenerate, generationRate, interval)
                ))
        );
    }

    // ================= 流体生成工厂方法 =================
    /**
     * 创建流体生成器升级
     * @param fluidToGenerate 要生成的流体和数量
     * @param generationRate 每次生成的流体量(mB)
     * @param interval 生成间隔（刻），也用作ConfigFluidGeneration的第三个参数
     */
    private static Item createFluidGenerator(FluidStack fluidToGenerate, int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
                        fluidToGenerate, generationRate, interval)
                ))
        );
    }
    // 特殊流体获取
    private static FluidStack getFluid(String fluidId, int amount) {
        var fluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidId));
        return new FluidStack(fluid, amount);
    }

    // ==================== 物品堆叠升级 ====================
    // 海龟鳞片升级
    public static final DeferredItem<MoreUpgradeItem> TURTLE_SCUTE_UPGRADE =
            ITEMS.register("turtle_scute_upgrade", () ->
                    new MoreUpgradeItem(MoreUpgradeItem.UpgradeType.TURTLE_SCUTE_UPGRADE));
    // 下界之星升级
    public static final DeferredItem<MoreUpgradeItem> NETHER_STAR_UPGRADE =
            ITEMS.register("nether_star_upgrade", () ->
                    new MoreUpgradeItem(MoreUpgradeItem.UpgradeType.NETHER_STAR_UPGRADE));
    // 重锤升级
    public static final DeferredItem<MoreUpgradeItem> HEAVY_CORE_UPGRADE =
            ITEMS.register("heavy_core_upgrade", () ->
                    new MoreUpgradeItem(MoreUpgradeItem.UpgradeType.HEAVY_CORE_UPGRADE));


    // ==================== 物品功能升级 ====================
    // 黑曜石生成升级T1 - 8个黑曜石/200tick
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_1 =
            ITEMS.register("obsidian_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.OBSIDIAN, 8), 8, 200)
            );
    // 黑曜石生成升级T2 - 16个黑曜石/80tick
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_2 =
            ITEMS.register("obsidian_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.OBSIDIAN, 32), 16, 80)
            );
    // 黑曜石生成升级T3 - 32个黑曜石/20tick
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_3 =
            ITEMS.register("obsidian_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.OBSIDIAN, 64), 32, 20)
            );
    // 黑曜石生成升级T4 - 64个黑曜石/5tick
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_4 =
            ITEMS.register("obsidian_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.OBSIDIAN, 64), 64, 5)
            );
    // 黑曜石生成升级T5 - 64个黑曜石/tick
    public static final DeferredItem<Item> OBSIDIAN_GENERATOR_UPGRADE_5 =
            ITEMS.register("obsidian_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.OBSIDIAN, 64), 64, 1)
            );

    // 圆石生成升级T1 - 8个圆石/20tick
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_1 =
            ITEMS.register("cobblestone_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.COBBLESTONE, 8), 8, 20)
            );
    // 圆石生成升级T2 - 16个圆石/15tick
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_2 =
            ITEMS.register("cobblestone_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.COBBLESTONE, 16), 16, 15)
            );
    // 圆石生成升级T3 - 32个圆石/10tick
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_3 =
            ITEMS.register("cobblestone_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.COBBLESTONE, 32), 32, 10)
            );
    // 圆石生成升级T4 - 64个圆石/5tick
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_4 =
            ITEMS.register("cobblestone_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.COBBLESTONE, 64), 64, 5)
            );
    // 圆石生成升级T5 - 64个圆石/tick
    public static final DeferredItem<Item> COBBLESTONE_GENERATOR_UPGRADE_5 =
            ITEMS.register("cobblestone_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.COBBLESTONE, 64), 64, 1)
            );

    // 泥土生成升级T1 - 8个泥土/20tick
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_1 =
            ITEMS.register("dirt_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.DIRT, 8), 8, 20)
            );
    // 泥土生成升级T2 - 16个泥土/15tick
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_2 =
            ITEMS.register("dirt_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.DIRT, 16), 16, 15)
            );
    // 泥土生成升级T3 - 32个泥土/10tick
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_3 =
            ITEMS.register("dirt_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.DIRT, 32), 32, 10)
            );
    // 泥土生成升级T4 - 64个泥土/5tick
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_4 =
            ITEMS.register("dirt_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.DIRT, 64), 64, 5)
            );
    // 泥土生成升级T4 - 64个泥土/tick
    public static final DeferredItem<Item> DIRT_GENERATOR_UPGRADE_5 =
            ITEMS.register("dirt_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.DIRT, 64), 64, 1)
            );

    // 沙子生成升级T1 - 8个沙子/20tick
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_1 =
            ITEMS.register("sand_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.SAND, 8), 8, 20)
            );
    // 沙子生成升级T2 - 16个沙子/15tick
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_2 =
            ITEMS.register("sand_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.SAND, 16), 16, 15)
            );
    // 沙子生成升级T3 - 32个沙子/10tick
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_3 =
            ITEMS.register("sand_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.SAND, 32), 32, 10)
            );
    // 沙子生成升级T4 - 64个沙子/5tick
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_4 =
            ITEMS.register("sand_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.SAND, 64), 64, 5)
            );
    // 沙子生成升级T5 - 64个沙子/tick
    public static final DeferredItem<Item> SAND_GENERATOR_UPGRADE_5 =
            ITEMS.register("sand_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.SAND, 64), 64, 1)
            );

    // 安山岩生成升级T1 - 8个安山岩/20tick
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_1 =
            ITEMS.register("andesite_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.ANDESITE, 8), 8, 20)
            );
    // 安山岩生成升级T2 - 16个安山岩/15tick
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_2 =
            ITEMS.register("andesite_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.ANDESITE, 16), 16, 15)
            );
    // 安山岩生成升级T3 - 32个安山岩/10tick
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_3 =
            ITEMS.register("andesite_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.ANDESITE, 32), 32, 10)
            );
    // 安山岩生成升级T4 - 64个安山岩/5tick
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_4 =
            ITEMS.register("andesite_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.ANDESITE, 64), 64, 5)
            );
    // 安山岩生成升级T4 - 64个安山岩/tick
    public static final DeferredItem<Item> ANDESITE_GENERATOR_UPGRADE_5 =
            ITEMS.register("andesite_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.ANDESITE, 64), 64, 1)
            );

    // 闪长岩生成升级T1 - 8个闪长岩/20tick
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_1 =
            ITEMS.register("diorite_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.DIORITE, 8), 8, 20)
            );
    // 闪长岩生成升级T2 - 16个闪长岩/15tick
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_2 =
            ITEMS.register("diorite_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.DIORITE, 16), 16, 15)
            );
    // 闪长岩生成升级T3 - 32个闪长岩/10tick
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_3 =
            ITEMS.register("diorite_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.DIORITE, 32), 32, 10)
            );
    // 闪长岩生成升级T4 - 64个闪长岩/5tick
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_4 =
            ITEMS.register("diorite_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.DIORITE, 64), 64, 5)
            );
    // 闪长岩生成升级T4 - 64个闪长岩/tick
    public static final DeferredItem<Item> DIORITE_GENERATOR_UPGRADE_5 =
            ITEMS.register("diorite_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.DIORITE, 64), 64, 1)
            );

    // 花岗岩生成升级T1 - 8个花岗岩/20tick
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_1 =
            ITEMS.register("granite_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.GRANITE, 8), 8, 20)
            );
    // 花岗岩生成升级T2 - 16个花岗岩/15tick
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_2 =
            ITEMS.register("granite_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.GRANITE, 16), 16, 15)
            );
    // 花岗岩生成升级T3 - 32个花岗岩/10tick
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_3 =
            ITEMS.register("granite_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.GRANITE, 32), 32, 10)
            );
    // 花岗岩生成升级T4 - 64个花岗岩/5tick
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_4 =
            ITEMS.register("granite_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.GRANITE, 64), 64, 5)
            );
    // 花岗岩生成升级T4 - 64个花岗岩/tick
    public static final DeferredItem<Item> GRANITE_GENERATOR_UPGRADE_5 =
            ITEMS.register("granite_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.GRANITE, 64), 64, 1)
            );

    // 深板岩圆石生成升级T1 - 8个深板岩圆石/20tick
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1 =
            ITEMS.register("cobbled_deepslate_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 8), 8, 20)
            );
    // 深板岩圆石生成升级T2 - 16个深板岩圆石/15tick
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2 =
            ITEMS.register("cobbled_deepslate_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 16), 16, 15)
            );
    // 深板岩圆石生成升级T3 - 32个深板岩圆石/10tick
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3 =
            ITEMS.register("cobbled_deepslate_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 32), 32, 10)
            );
    // 深板岩圆石生成升级T4 - 64个深板岩圆石/5tick
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4 =
            ITEMS.register("cobbled_deepslate_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 64), 64, 5)
            );
    // 深板岩圆石生成升级T4 - 64个深板岩圆石/tick
    public static final DeferredItem<Item> COBBLED_DEEPSLATE_GENERATOR_UPGRADE_5 =
            ITEMS.register("cobbled_deepslate_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.COBBLED_DEEPSLATE, 64), 64, 1)
            );

    // 黑石生成升级T1 - 8个黑石/20tick
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_1 =
            ITEMS.register("blackstone_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.BLACKSTONE, 8), 8, 20)
            );
    // 黑石生成升级T2 - 16个黑石/15tick
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_2 =
            ITEMS.register("blackstone_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.BLACKSTONE, 16), 16, 15)
            );
    // 黑石生成升级T3 - 32个黑石/10tick
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_3 =
            ITEMS.register("blackstone_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.BLACKSTONE, 32), 32, 10)
            );
    // 黑石生成升级T4 - 64个黑石/5tick
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_4 =
            ITEMS.register("blackstone_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.BLACKSTONE, 64), 64, 5)
            );
    // 黑石生成升级T4 - 64个黑石/tick
    public static final DeferredItem<Item> BLACKSTONE_GENERATOR_UPGRADE_5 =
            ITEMS.register("blackstone_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.BLACKSTONE, 64), 64, 1)
            );

    // 下界岩生成升级T1 - 8个下界岩/20tick
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_1 =
            ITEMS.register("netherrack_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.NETHERRACK, 8), 8, 20)
            );
    // 下界岩生成升级T2 - 16个下界岩/15tick
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_2 =
            ITEMS.register("netherrack_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.NETHERRACK, 16), 16, 15)
            );
    // 下界岩生成升级T3 - 32个下界岩/10tick
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_3 =
            ITEMS.register("netherrack_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.NETHERRACK, 32), 32, 10)
            );
    // 下界岩生成升级T4 - 64个下界岩/5tick
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_4 =
            ITEMS.register("netherrack_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.NETHERRACK, 64), 64, 5)
            );
    // 下界岩生成升级T4 - 64个下界岩/tick
    public static final DeferredItem<Item> NETHERRACK_GENERATOR_UPGRADE_5 =
            ITEMS.register("netherrack_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.NETHERRACK, 64), 64, 1)
            );

    // 末地石生成升级T1 - 8个末地石/20tick
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_1 =
            ITEMS.register("end_stone_generator_upgrade_1", () ->
                    createItemGenerator(new ItemStack(Items.END_STONE, 8), 8, 20)
            );
    // 末地石生成升级T2 - 16个末地石/15tick
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_2 =
            ITEMS.register("end_stone_generator_upgrade_2", () ->
                    createItemGenerator(new ItemStack(Items.END_STONE, 16), 16, 15)
            );
    // 末地石生成升级T3 - 32个末地石/10tick
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_3 =
            ITEMS.register("end_stone_generator_upgrade_3", () ->
                    createItemGenerator(new ItemStack(Items.END_STONE, 32), 32, 10)
            );
    // 末地石生成升级T4 - 64个末地石/5tick
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_4 =
            ITEMS.register("end_stone_generator_upgrade_4", () ->
                    createItemGenerator(new ItemStack(Items.END_STONE, 64), 64, 5)
            );
    // 末地石生成升级T4 - 64个末地石/tick
    public static final DeferredItem<Item> END_STONE_GENERATOR_UPGRADE_5 =
            ITEMS.register("end_stone_generator_upgrade_5", () ->
                    createItemGenerator(new ItemStack(Items.END_STONE, 64), 64, 1)
            );


    // ==================== 流体功能升级 ====================
    // 水生成升级T1 - 32000mB/20tick
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_1 =
            ITEMS.register("water_generator_upgrade_1", () ->
                    createFluidGenerator(new FluidStack(Fluids.WATER, 32000), 32000, 20)
            );
    // 水生成升级T2 - 128000mB/15tick
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_2 =
            ITEMS.register("water_generator_upgrade_2", () ->
                    createFluidGenerator(new FluidStack(Fluids.WATER, 128000), 128000, 15)
            );
    // 水生成升级T3 - 512000mB/10tick
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_3 =
            ITEMS.register("water_generator_upgrade_3", () ->
                    createFluidGenerator(new FluidStack(Fluids.WATER, 512000), 512000, 10)
            );
    // 水生成升级T4 - 1024000mB/5tick
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_4 =
            ITEMS.register("water_generator_upgrade_4", () ->
                    createFluidGenerator(new FluidStack(Fluids.WATER, 1024000), 1024000, 5)
            );
    // 水生成升级T4 - 2048000mB/tick
    public static final DeferredItem<Item> WATER_GENERATOR_UPGRADE_5 =
            ITEMS.register("water_generator_upgrade_5", () ->
                    createFluidGenerator(new FluidStack(Fluids.WATER, 2048000), 2048000, 1)
            );

    // 滴水生成升级T1 - 50mB/20tick
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_1 =
            ITEMS.register("lava_generator_upgrade_1", () ->
                    createFluidGenerator(new FluidStack(Fluids.LAVA, 50), 50, 20)
            );
    // 滴水生成升级T2 - 1000mB/15tick
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_2 =
            ITEMS.register("lava_generator_upgrade_2", () ->
                    createFluidGenerator(new FluidStack(Fluids.LAVA, 250), 250, 15)
            );
    // 滴水生成升级T3 - 1000mB/10tick
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_3 =
            ITEMS.register("lava_generator_upgrade_3", () ->
                    createFluidGenerator(new FluidStack(Fluids.LAVA, 1000), 1000, 10)
            );
    // 滴水生成升级T4 - 2500mB/5tick
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_4 =
            ITEMS.register("lava_generator_upgrade_4", () ->
                    createFluidGenerator(new FluidStack(Fluids.LAVA, 2500), 2500, 5)
            );
    // 滴水生成升级T4 - 5000mB/tick
    public static final DeferredItem<Item> LAVA_GENERATOR_UPGRADE_5 =
            ITEMS.register("lava_generator_upgrade_5", () ->
                    createFluidGenerator(new FluidStack(Fluids.LAVA, 5000), 5000, 1)
            );

    // 牛奶生成升级T1 - 50mB/20tick
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_1 =
            ITEMS.register("milk_generator_upgrade_1", () ->
                    createFluidGenerator(getFluid("minecraft:milk", 50), 50, 20)
            );
    // 牛奶生成升级T2 - 250mB/15tick
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_2 =
            ITEMS.register("milk_generator_upgrade_2", () ->
                    createFluidGenerator(getFluid("minecraft:milk", 250), 250, 15)
            );
    // 牛奶生成升级T3 - 1000mB/10tick
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_3 =
            ITEMS.register("milk_generator_upgrade_3", () ->
                    createFluidGenerator(getFluid("minecraft:milk", 1000), 1000, 10)
            );
    // 牛奶生成升级T4 - 2500mB/5tick
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_4 =
            ITEMS.register("milk_generator_upgrade_4", () ->
                    createFluidGenerator(getFluid("minecraft:milk", 2500), 2500, 5)
            );
    // 牛奶生成升级T4 - 5000mB/tick
    public static final DeferredItem<Item> MILK_GENERATOR_UPGRADE_5 =
            ITEMS.register("milk_generator_upgrade_5", () ->
                    createFluidGenerator(getFluid("minecraft:milk", 5000), 5000, 1)
            );


    // 注册方法
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}