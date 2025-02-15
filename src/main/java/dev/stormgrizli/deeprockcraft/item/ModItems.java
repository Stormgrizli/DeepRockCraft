package dev.stormgrizli.deeprockcraft.item;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeepRockCraftMod.MOD_ID);
    public static void register(IEventBus Nitra ) {
        ITEMS.register(Nitra);
    }
    public static final RegistryObject<Item> NITRA_ORE = ITEMS.register("nitra_ore",
            () -> new Item(new Item.Properties()));

}
