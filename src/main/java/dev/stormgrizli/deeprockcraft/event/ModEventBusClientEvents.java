package dev.stormgrizli.deeprockcraft.event;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.entity.ModBlockEntities;
import dev.stormgrizli.deeprockcraft.block.entity.renderer.CrystalRenderer;
import dev.stormgrizli.deeprockcraft.entity.ModEntities;
import dev.stormgrizli.deeprockcraft.entity.client.GlyphidGruntModel;
import dev.stormgrizli.deeprockcraft.entity.client.ModModelLayers;
import dev.stormgrizli.deeprockcraft.entity.renderer.GlyphidGruntRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static dev.stormgrizli.deeprockcraft.block.ModBlocks.CRYSTALS_BLOCK;

@Mod.EventBusSubscriber(modid = DeepRockCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.glyphidgrunt_layer, GlyphidGruntModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.GRYPHID_GRUNT.get(), GlyphidGruntRenderer::new);
        ItemBlockRenderTypes.setRenderLayer(CRYSTALS_BLOCK.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.CRYSTAL_BE.get(), CrystalRenderer::new);
    }
}
