package dev.stormgrizli.deeprockcraft.event;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.registries.DRCEntities;
import dev.stormgrizli.deeprockcraft.entity.client.GlyphidGruntModel;
import dev.stormgrizli.deeprockcraft.entity.client.DRCModelLayers;
import dev.stormgrizli.deeprockcraft.entity.renderer.GlyphidGruntRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static dev.stormgrizli.deeprockcraft.registries.DRCBlocks.CRYSTALS_BLOCK;

@Mod.EventBusSubscriber(modid = DeepRockCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DRCEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DRCModelLayers.glyphidgrunt_layer, GlyphidGruntModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(DRCEntities.GRYPHID_GRUNT.get(), GlyphidGruntRenderer::new);
        ItemBlockRenderTypes.setRenderLayer(CRYSTALS_BLOCK.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(ModBlockEntities.CRYSTAL_BE.get(), CrystalRenderer::new);
    }
}
