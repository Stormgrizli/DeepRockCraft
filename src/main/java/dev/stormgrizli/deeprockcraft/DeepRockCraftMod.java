package dev.stormgrizli.deeprockcraft;


import com.mojang.logging.LogUtils;
import dev.stormgrizli.deeprockcraft.event.DRCEventBusClientEvents;
import dev.stormgrizli.deeprockcraft.event.DRCEventBusEvents;
import dev.stormgrizli.deeprockcraft.registries.*;
import dev.stormgrizli.deeprockcraft.worldgen.DRCFeature;
import dev.stormgrizli.deeprockcraft.worldgen.DRCPlacedFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
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

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "deeprockcraft";

    public DeepRockCraftMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        modEventBus.addListener(this::commonSetup);

        DRCBlocks.BLOCKS.register(modEventBus);
        DRCBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        DRCCreativeTab.CREATIVE_TAB.register(modEventBus);
        DRCEntities.ENTITY_TYPES.register(modEventBus);
        DRCFeature.FEATURES.register(modEventBus);
        DRCItems.ITEMS.register(modEventBus);
//        GMobEffects.MOB_EFFECTS.register(modEventBus);
//        GMemoryModuleTypes.MEMORY_MODULE_TYPES.register(modEventBus);
//        GMenuTypes.MENU_TYPES.register(modEventBus);
//        GPotions.POTIONS.register(modEventBus);
//        GParticleTypes.PARTICLES.register(modEventBus);
//        GRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
//        GStructureProcessorTypes.STRUCTURE_PROCESSOR_TYPES.register(modEventBus);
//        GSensorTypes.SENSOR_TYPES.register(modEventBus);
//        GSoundEvents.SOUND_EVENTS.register(modEventBus);

        eventBus.register(this);
        eventBus.register(new DRCEventBusEvents());
        eventBus.register(new DRCEventBusClientEvents());

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DRCPlacedFeatures.init();
//            DRCPotions.init();
        });
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(DeepRockCraftMod.MOD_ID, path);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(DRCItems.NITRA_ORE);
        }
    }
}
