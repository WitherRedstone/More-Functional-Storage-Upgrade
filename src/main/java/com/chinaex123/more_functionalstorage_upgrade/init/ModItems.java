package com.chinaex123.more_functionalstorage_upgrade.init;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public interface ModItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(MoreFunctionalStorageUpgrade.MOD_ID);

    ResourceLocation EMPTY_SLOT_GENERATOR_UPGRADE = ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "item/empty_slot_generator_upgrade");
    ResourceLocation EMPTY_SLOT_HEART_OF_THE_SEA = ResourceLocation.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "item/empty_slot_heart_of_the_sea");

    DeferredItem<SmithingTemplateItem> GENERATOR_UPGRADE_SMITHING_TEMPLATE =
            ITEMS_REGISTER.register("generator_upgrade_smithing_template",
                    () -> new SmithingTemplateItem(
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.applies_to").withStyle(ChatFormatting.BLUE),
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.ingredients").withStyle(ChatFormatting.BLUE),
                            Component.translatable("upgrade.more_functionalstorage_upgrade.generator_upgrade").withStyle(ChatFormatting.GRAY),
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.base_slot_description"),
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.additions_slot_description"),
                            List.of(EMPTY_SLOT_GENERATOR_UPGRADE),
                            List.of(EMPTY_SLOT_HEART_OF_THE_SEA)
//                            List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS, EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL),
//                            List.of(EMPTY_SLOT_INGOT)
                    ));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
