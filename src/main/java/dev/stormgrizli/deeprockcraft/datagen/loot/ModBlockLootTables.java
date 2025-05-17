package dev.stormgrizli.deeprockcraft.datagen.loot;

import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import dev.stormgrizli.deeprockcraft.registries.DRCItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        this.add(DRCBlocks.NITRA_BLOCK.get(),
                block -> createCopperLikeOreDrops(DRCBlocks.NITRA_BLOCK.get(), DRCItems.NITRA_ORE.get()));
        this.dropSelf(DRCBlocks.RED_SALT.get());
        this.dropSelf(DRCBlocks.WINE_SALT.get());
        this.dropSelf(DRCBlocks.CRYSTALLINE_STONE.get());
        this.dropSelf(DRCBlocks.WHITE_CRYSTALLINE_STONE.get());
        this.dropSelf(DRCBlocks.ROSE_SALT.get());
        this.dropSelf(DRCBlocks.MAGMA_CORE_BLOCK.get());
        this.dropSelf(DRCBlocks.DARK_MAGMA_CORE_BLOCK.get());
        this.dropSelf(DRCBlocks.SAND_BLASED_STONE.get());
        this.dropSelf(DRCBlocks.YL_SAND_BLASED_STONE.get());
        this.dropSelf(DRCBlocks.RADIATED_STONE.get());
        this.dropSelf(DRCBlocks.GLACIAL_STONE.get());
        this.dropSelf(DRCBlocks.AZURE_STONE.get());
        this.dropSelf(DRCBlocks.FUNGUS_STONE.get());
        this.dropSelf(DRCBlocks.BIOZONE_STONE.get());
        this.dropSelf(DRCBlocks.HOLLOW_BOUGH_STONE.get());
    }
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DRCBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}