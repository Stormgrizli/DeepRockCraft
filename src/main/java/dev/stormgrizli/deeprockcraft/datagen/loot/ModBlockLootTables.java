package dev.stormgrizli.deeprockcraft.datagen.loot;

import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import dev.stormgrizli.deeprockcraft.item.ModItems;
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
        this.add(ModBlocks.NITRA_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NITRA_BLOCK.get(), ModItems.NITRA_ORE.get()));
        this.dropSelf(ModBlocks.RED_SALT.get());
        this.dropSelf(ModBlocks.WINE_SALT.get());
        this.dropSelf(ModBlocks.CRYSTALLINE_STONE.get());
        this.dropSelf(ModBlocks.CRYSTALLINE_STONE_SLAB.get());
        this.dropSelf(ModBlocks.ROSE_SALT.get());
        this.dropSelf(ModBlocks.MAGMA_CORE_BLOCK.get());
        this.dropSelf(ModBlocks.DARK_MAGMA_CORE_BLOCK.get());
        this.dropSelf(ModBlocks.SAND_BLASED_STONE.get());
        this.dropSelf(ModBlocks.YL_SAND_BLASED_STONE.get());
        this.dropSelf(ModBlocks.RADIATED_STONE.get());
        this.dropSelf(ModBlocks.GLACIAL_STONE.get());
        this.dropSelf(ModBlocks.AZURE_STONE.get());
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
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}