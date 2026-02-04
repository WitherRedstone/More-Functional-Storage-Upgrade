package com.chinaex123.more_functionalstorage_upgrade.register;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.register.ModCompat.CreateCompat;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreFunctionalStorageUpgrade.MOD_ID);

    public static final Supplier<CreativeModeTab> MORE_FUNCTIONALSTORAGE_UPGRADE_TAB =
            CREATIVE_MODE_TAB.register("more_functionalstorage_upgrade_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()))
                    .title(Component.translatable("itemGroup.more_functionalstorage_upgrade_tab"))
                    .displayItems((parameters, output) -> {

                        // ==================== 物品堆叠升级 ====================
                        output.accept(CustomUpgradeItem.TURTLE_SCUTE_UPGRADE.get()); // 鳞甲升级
                        output.accept(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()); // 下界之星升级
                        output.accept(CustomUpgradeItem.HEAVY_CORE_UPGRADE.get()); // 重锤升级

                        // ==================== 物品功能升级 ====================
                        // 黑曜石生成升级
                        output.accept(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.OBSIDIAN_GENERATOR_UPGRADE_4.get());
                        // 圆石生成升级
                        output.accept(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_4.get());
                        // 泥土生成升级
                        output.accept(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.DIRT_GENERATOR_UPGRADE_4.get());
                        // 沙子生成升级
                        output.accept(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.SAND_GENERATOR_UPGRADE_4.get());
                        // 安山岩生成升级
                        output.accept(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.ANDESITE_GENERATOR_UPGRADE_4.get());
                        // 闪长岩生成升级
                        output.accept(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.DIORITE_GENERATOR_UPGRADE_4.get());
                        // 花岗岩生成升级
                        output.accept(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.GRANITE_GENERATOR_UPGRADE_4.get());
                        // 深板岩圆石生成升级
                        output.accept(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.COBBLED_DEEPSLATE_GENERATOR_UPGRADE_4.get());
                        // 黑石生成升级
                        output.accept(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.BLACKSTONE_GENERATOR_UPGRADE_4.get());
                        // 下界岩生成升级
                        output.accept(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.NETHERRACK_GENERATOR_UPGRADE_4.get());
                        // 末地石生成升级
                        output.accept(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.END_STONE_GENERATOR_UPGRADE_4.get());



                        // ==================== 流体功能升级 ====================
                        // 水生成升级
                        output.accept(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.WATER_GENERATOR_UPGRADE_4.get());
                        // 滴水生成升级
                        output.accept(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.LAVA_GENERATOR_UPGRADE_4.get());
                        // 牛奶生成升级
                        output.accept(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_1.get());
                        output.accept(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_2.get());
                        output.accept(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_3.get());
                        output.accept(CustomUpgradeItem.MILK_GENERATOR_UPGRADE_4.get());

                        // 加载 机械动力 时注册
                        if (ModList.get().isLoaded("create")) {
                            // 蜂蜜生成升级
                            output.accept(CreateCompat.HONEY_GENERATOR_UPGRADE_1.get());
                            output.accept(CreateCompat.HONEY_GENERATOR_UPGRADE_2.get());
                            output.accept(CreateCompat.HONEY_GENERATOR_UPGRADE_3.get());
                            output.accept(CreateCompat.HONEY_GENERATOR_UPGRADE_4.get());
                        }

                    })
                    .build());

    // 注册到NeoForge事件总线里
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
