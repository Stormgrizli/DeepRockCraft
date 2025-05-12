package dev.stormgrizli.deeprockcraft;


import com.mojang.logging.LogUtils;
import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import dev.stormgrizli.deeprockcraft.block.entity.ModBlockEntities;
import dev.stormgrizli.deeprockcraft.entity.ModEntities;
import dev.stormgrizli.deeprockcraft.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DeepRockCraftMod.MOD_ID)
public class DeepRockCraftMod {
    public static final String MOD_ID = "deeprockcraft";
    public static final Logger LOGGER = LogUtils.getLogger();
    public DeepRockCraftMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
}
