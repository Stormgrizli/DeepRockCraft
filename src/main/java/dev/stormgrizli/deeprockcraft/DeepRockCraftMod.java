package dev.stormgrizli.deeprockcraft;


import com.mojang.logging.LogUtils;
import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import dev.stormgrizli.deeprockcraft.entity.ModEntities;
import dev.stormgrizli.deeprockcraft.entity.renderer.GlyphidGruntRenderer;
import dev.stormgrizli.deeprockcraft.item.ModItems;
import dev.stormgrizli.deeprockcraft.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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

        //ModWorldGen.register(FMLJavaModLoadingContext.get().getModEventBus());

        modEventBus.addListener(this::commonSetup);

        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.GRYPHID_GRUNT.get(), GlyphidGruntRenderer::new);

        }
    }
}
