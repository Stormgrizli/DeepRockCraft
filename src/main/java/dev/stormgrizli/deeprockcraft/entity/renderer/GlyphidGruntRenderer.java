package dev.stormgrizli.deeprockcraft.entity.renderer;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.entity.client.GlyphidGruntModel;
import dev.stormgrizli.deeprockcraft.entity.client.DRCModelLayers;
import dev.stormgrizli.deeprockcraft.entity.custom.GlyphidGruntEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GlyphidGruntRenderer extends MobRenderer<GlyphidGruntEntity, GlyphidGruntModel<GlyphidGruntEntity>> {
    public GlyphidGruntRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GlyphidGruntModel<>(pContext.bakeLayer(DRCModelLayers.glyphidgrunt_layer)), 1f);
    }


    @Override
    public ResourceLocation getTextureLocation(GlyphidGruntEntity pEntity) {
        return new ResourceLocation(DeepRockCraftMod.MOD_ID, "textures/entity/glyphid_grunt.png");
    }
}
