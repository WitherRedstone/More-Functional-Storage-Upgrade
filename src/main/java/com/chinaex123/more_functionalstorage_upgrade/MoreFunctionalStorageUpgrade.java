package com.chinaex123.more_functionalstorage_upgrade;

import com.buuz135.functionalstorage.item.component.FunctionalUpgradeBehavior;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.ConfigItemGeneration;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.register.Fluid.ConfigFluidGeneration;
import com.chinaex123.more_functionalstorage_upgrade.register.Item.ModItems;
import com.chinaex123.more_functionalstorage_upgrade.register.ModCompat.CreateCompat;
import com.chinaex123.more_functionalstorage_upgrade.register.ModCreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// 这里的值应与 META-INF/neoforge.mods.toml 文件中的条目对应
@Mod(MoreFunctionalStorageUpgrade.MOD_ID)
public class MoreFunctionalStorageUpgrade {
    // 在公共位置定义模组ID，供所有地方引用
    public static final String MOD_ID = "more_functionalstorage_upgrade";
    // 直接引用 slf4j 日志记录器
    public static final Logger LOGGER = LogUtils.getLogger();

    // 模组类的构造函数是模组加载时运行的第一段代码
    // FML 会自动识别某些参数类型（如 IEventBus 或 ModContainer）并传入
    public MoreFunctionalStorageUpgrade(IEventBus modEventBus, ModContainer modContainer) {
        // 为模组加载注册 commonSetup 方法
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerBehaviors); // 添加行为注册监听器
        NeoForge.EVENT_BUS.register(this);

        // 将物品注册到游戏
        ModCreativeTabs.register(modEventBus); // 创造模式物品栏

        CustomUpgradeItem.register(modEventBus); // 注册物品
        ModItems.register(modEventBus); // 注册锻造模板

        // 模组兼容 - 机械动力
        if (ModList.get().isLoaded("create")) {
            LOGGER.info("Create mod detected, registering compatibility...");
            CreateCompat.register();
        }

    }

    /**
     * 注册自定义功能升级行为
     */
    private void registerBehaviors(RegisterEvent event) {
        // 检查是否是功能升级行为的注册表
        if (event.getRegistryKey().equals(FunctionalUpgradeBehavior.REGISTRY_KEY)) {
            // 注册配置化流体生成行为
            event.register(
                    FunctionalUpgradeBehavior.REGISTRY_KEY,
                    ResourceLocation.fromNamespaceAndPath(MOD_ID, "configurable_fluid_generation"),
                    () -> ConfigFluidGeneration.CODEC
            );

            // 注册配置化物品生成行为
            event.register(
                    FunctionalUpgradeBehavior.REGISTRY_KEY,
                    ResourceLocation.fromNamespaceAndPath(MOD_ID, "configurable_item_generation"),
                    () -> ConfigItemGeneration.CODEC
            );
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    // 可以使用 @SubscribeEvent 并让事件总线自动发现要调用的方法
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
