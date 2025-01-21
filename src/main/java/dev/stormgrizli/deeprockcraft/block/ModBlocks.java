package dev.stormgrizli.deeprockcraft.block;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.custom.ModPortalBlock;
import dev.stormgrizli.deeprockcraft.block.custom.NitraBlock;
import dev.stormgrizli.deeprockcraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
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
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static final RegistryObject<Block> NITRA_BLOCK = registerBlock("nitra_block",
            () -> new NitraBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).strength(1)));
    public static final RegistryObject<Block> MOD_PORTAL = registerBlock("mod_portal",
            () -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noCollission()));
    public static final RegistryObject<Block> RED_SALT = registerBlock("red_salt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CRYSTALLINE_STONE = registerBlock("crystalline_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CRYSTALLINE_STONE_SLAB = registerBlock("crystalline_stone_slab",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
}
