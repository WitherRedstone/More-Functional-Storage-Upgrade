package com.chinaex123.more_functionalstorage_upgrade.data;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.data.recipes.ModRecipesProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MoreFunctionalStorageUpgrade.MOD_ID)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipesProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeClient(), new ModItemModelsProvider(packOutput, event.getExistingFileHelper()));
    }
}