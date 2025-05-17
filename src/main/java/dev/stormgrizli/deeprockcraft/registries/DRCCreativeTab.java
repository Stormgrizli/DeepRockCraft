package dev.stormgrizli.deeprockcraft.registries;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DRCCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeepRockCraftMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> DeepRockCraft = CREATIVE_TAB.register("deeprockcraft",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DRCBlocks.NITRA_BLOCK.get()))
                    .title(Component.translatable("creativetab.deeprockcraft"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(DRCBlocks.MOD_PORTAL.get());
                        pOutput.accept(DRCItems.NITRA_ORE.get());
                        pOutput.accept(DRCBlocks.NITRA_BLOCK.get());
                        pOutput.accept(DRCBlocks.RED_SALT.get());
                        pOutput.accept(DRCBlocks.ROSE_SALT.get());
                        pOutput.accept(DRCBlocks.WINE_SALT.get());
                        pOutput.accept(DRCBlocks.CRYSTALLINE_STONE.get());
                        pOutput.accept(DRCBlocks.GLACIAL_STONE.get());
                        pOutput.accept(DRCBlocks.AZURE_STONE.get());
                        pOutput.accept(DRCBlocks.BIOZONE_STONE.get());
                        pOutput.accept(DRCBlocks.FUNGUS_STONE.get());
                        pOutput.accept(DRCBlocks.SAND_BLASED_STONE.get());
                        pOutput.accept(DRCBlocks.HOLLOW_BOUGH_STONE.get());
                        pOutput.accept(DRCBlocks.DARK_MAGMA_CORE_BLOCK.get());
                        pOutput.accept(DRCBlocks.RADIATED_STONE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TAB.register(eventBus);
    }
}
