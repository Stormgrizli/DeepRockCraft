package dev.stormgrizli.deeprockcraft.registries;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.custom.CrystalsBlock;
import dev.stormgrizli.deeprockcraft.block.custom.ModPortalBlock;
import dev.stormgrizli.deeprockcraft.block.custom.NitraBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class DRCBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeepRockCraftMod.MOD_ID);
    public static void register(IEventBus Nitra ) {
        BLOCKS.register(Nitra);
    }
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        DRCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static final RegistryObject<Block> NITRA_BLOCK = registerBlock("nitra_block",
            () -> new NitraBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).strength(1)));
    public static final RegistryObject<Block> MOD_PORTAL = registerBlock("mod_portal",
            () -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noCollission()));
    public static final RegistryObject<Block> RED_SALT = registerBlock("red_salt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WINE_SALT = registerBlock("wine_salt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CRYSTALLINE_STONE = registerBlock("crystalline_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WHITE_CRYSTALLINE_STONE = registerBlock("white_crystalline_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> ROSE_SALT = registerBlock("rose_salt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> DARK_MAGMA_CORE_BLOCK = registerBlock("dark_magma_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> MAGMA_CORE_BLOCK = registerBlock("magma_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SAND_BLASED_STONE = registerBlock("sand_blased_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> YL_SAND_BLASED_STONE = registerBlock("yl_sand_blased_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> RADIATED_STONE = registerBlock("radiated_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> AZURE_STONE = registerBlock("azure_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> GLACIAL_STONE = registerBlock("glacial_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ICE)));
    public static final RegistryObject<Block> HOLLOW_BOUGH_STONE = registerBlock("hollow_bough_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> FUNGUS_STONE = registerBlock("fungus_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> BIOZONE_STONE = registerBlock("biozone_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> RED_BIG_CRYSTAL = registerBlock("red_big_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).noLootTable()));
    public static final RegistryObject<Block> CRYSTALS_BLOCK = registerBlock("crystals_block",
            () -> new CrystalsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noLootTable().noOcclusion().noCollission()));
}
