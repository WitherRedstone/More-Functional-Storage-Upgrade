package com.chinaex123.more_functionalstorage_upgrade.register.ModCompat;

import com.buuz135.functionalstorage.item.FSAttachments;
import com.buuz135.functionalstorage.item.FSItem;
import com.buuz135.functionalstorage.item.component.ExecuteEveryBehavior;
import com.chinaex123.more_functionalstorage_upgrade.register.Fluid.ConfigFluidGeneration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.chinaex123.more_functionalstorage_upgrade.register.Item.CustomUpgradeItem.ITEMS;

public class CreateCompat {

    // 检查 机械动力 是否已安装
    public static boolean CREATE_LOADED() {
        return ModList.get().isLoaded("create");
    }

    // 获取机械动力的蜂蜜流体
    private static FluidStack getHoneyFluid(int amount) {
        var honeyFluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse("create:honey"));
        return new FluidStack(honeyFluid, amount);
    }

    // ==================== 创建升级物品的工厂方法 ====================
    /**
     * 创建蜂蜜生成器升级（机械动力专用）
     * @param generationRate 每次生成的蜂蜜量(mB)
     * @param interval 生成间隔（刻），也用作ConfigFluidGeneration的第三个参数
     */
    private static Item CreateUpgrade(int generationRate, int interval) {
        return new FSItem(new Item.Properties().component(FSAttachments.FUNCTIONAL_BEHAVIOR,
                new ExecuteEveryBehavior(interval, new ConfigFluidGeneration(
                        getHoneyFluid(generationRate), generationRate, interval)
                ))
        );
    }

    // 注册机械动力兼容物品
    // 蜂蜜升级T1 - 10mB/20tick
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_1 =
            ITEMS.register("honey_generator_upgrade_1",
                    () -> CreateUpgrade(10, 20));
    // 蜂蜜升级T2 - 100mB/15tick
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_2 =
            ITEMS.register("honey_generator_upgrade_2",
                    () -> CreateUpgrade(100, 15));
    // 蜂蜜升级T3 - 500mB/10tick
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_3 =
            ITEMS.register("honey_generator_upgrade_3",
                    () -> CreateUpgrade(500, 10));
    // 蜂蜜升级T4 - 1000mB/5tick
    public static final DeferredItem<Item> HONEY_GENERATOR_UPGRADE_4 =
            ITEMS.register("honey_generator_upgrade_4",
                    () -> CreateUpgrade(1000, 5));


    // 注册方法，在主类中调用
    public static void register() {
        //var item = HONEY_GENERATOR_UPGRADE_1;
    }
}