package dev.stormgrizli.deeprockcraft.registries;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DRCItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeepRockCraftMod.MOD_ID);
    public static void register(IEventBus Nitra ) {
        ITEMS.register(Nitra);
    }
    public static final RegistryObject<Item> NITRA_ORE = ITEMS.register("nitra_ore",
            () -> new Item(new Item.Properties()));

}
