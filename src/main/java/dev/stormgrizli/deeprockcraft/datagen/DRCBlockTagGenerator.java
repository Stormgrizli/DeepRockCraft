package dev.stormgrizli.deeprockcraft.datagen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import dev.stormgrizli.deeprockcraft.registries.DRCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DRCBlockTagGenerator extends BlockTagsProvider {
    public DRCBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeepRockCraftMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(DRCBlocks.NITRA_BLOCK.get());
        this.tag(DRCTags.Blocks.NITRA_REPLACEABLE)
                .add(DRCBlocks.RED_SALT.get())
                .add(DRCBlocks.ROSE_SALT.get())
                .add(DRCBlocks.WINE_SALT.get())
                .add(DRCBlocks.CRYSTALLINE_STONE.get())
                .add(DRCBlocks.WHITE_CRYSTALLINE_STONE.get())
                .add(DRCBlocks.GLACIAL_STONE.get())
                .add(DRCBlocks.AZURE_STONE.get())
                .add(DRCBlocks.BIOZONE_STONE.get())
                .add(DRCBlocks.FUNGUS_STONE.get())
                .add(DRCBlocks.SAND_BLASED_STONE.get())
                .add(DRCBlocks.HOLLOW_BOUGH_STONE.get())
                .add(DRCBlocks.DARK_MAGMA_CORE_BLOCK.get())
                .add(DRCBlocks.YL_SAND_BLASED_STONE.get())
                .add(DRCBlocks.RADIATED_STONE.get());
    }
}

