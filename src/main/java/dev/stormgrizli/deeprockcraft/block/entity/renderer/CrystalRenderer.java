package dev.stormgrizli.deeprockcraft.block.entity.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.stormgrizli.deeprockcraft.block.entity.CrystalBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

public class CrystalRenderer implements BlockEntityRenderer<CrystalBlockEntity> {
    public CrystalRenderer(BlockEntityRendererProvider.Context context) {
    }

    private BakedModel getCrystalModel() {
        // Загружаем модель кристалла
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(new ResourceLocation("deeprockcraft:block/crystals/crystals_v1_block"));


        return model;
    }

    @Override
    public void render(CrystalBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        BlockState mimicBlock = null;
        if (level != null) {
            mimicBlock = level.getBlockState(blockEntity.getBlockPos().relative(blockEntity.getBlockState().getValue(FACING).getOpposite()));
        }
        if (mimicBlock != null) {
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(
                    mimicBlock,
                    poseStack,
                    bufferSource,
                    packedLight,
                    packedOverlay
            );
        }

        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                poseStack.last(),
                bufferSource.getBuffer(RenderType.translucent()),
                mimicBlock,
                getCrystalModel(),
                1.0F, 1.0F, 1.0F,
                packedLight,
                packedOverlay
        );
        poseStack.popPose();

        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}