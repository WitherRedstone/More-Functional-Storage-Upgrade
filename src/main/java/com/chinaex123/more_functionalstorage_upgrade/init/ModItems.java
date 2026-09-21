package com.chinaex123.more_functionalstorage_upgrade.init;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public interface ModItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(MoreFunctionalStorageUpgrade.MOD_ID);

    Identifier EMPTY_SLOT_GENERATOR_UPGRADE = Identifier.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "item/empty_slot_generator_upgrade");
    Identifier EMPTY_SLOT_HEART_OF_THE_SEA = Identifier.fromNamespaceAndPath(MoreFunctionalStorageUpgrade.MOD_ID, "item/empty_slot_heart_of_the_sea");

    /** 海洋之心锻造模板 */
    DeferredItem<SmithingTemplateItem> GENERATOR_UPGRADE_SMITHING_TEMPLATE =
            ITEMS_REGISTER.registerItem("generator_upgrade_smithing_template",
                    p -> new SmithingTemplateItem(
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.applies_to").withStyle(ChatFormatting.BLUE),
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.ingredients").withStyle(ChatFormatting.BLUE),
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.base_slot_description"),
                            Component.translatable("item.more_functionalstorage_upgrade.generator_upgrade_smithing_template.additions_slot_description"),
                            List.of(EMPTY_SLOT_GENERATOR_UPGRADE),
                            List.of(EMPTY_SLOT_HEART_OF_THE_SEA),
                            p
                    ));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}