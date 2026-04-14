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

@Mod(MoreFunctionalStorageUpgrade.MOD_ID)
public class MoreFunctionalStorageUpgrade {
    public static final String MOD_ID = "more_functionalstorage_upgrade";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MoreFunctionalStorageUpgrade(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::registerBehaviors);

        ModCreativeTabs.register(modEventBus);
        CustomUpgradeItem.register(modEventBus);
        ModItems.register(modEventBus);

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
}
