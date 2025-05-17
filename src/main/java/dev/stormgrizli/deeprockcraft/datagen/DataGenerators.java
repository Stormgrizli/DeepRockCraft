package dev.stormgrizli.deeprockcraft.datagen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DeepRockCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        PackOutput packOutput = generator.getPackOutput();

        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new DRCBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new DRCItemModelProvider(packOutput, existingFileHelper));

        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        DRCBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new DRCBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), DRCLootTableProvider.create(packOutput));

        generator.addProvider(event.includeServer(), new DRCWorldGenProvider(packOutput, lookupProvider));
    }
}
