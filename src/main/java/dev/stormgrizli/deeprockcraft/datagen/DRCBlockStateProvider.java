package dev.stormgrizli.deeprockcraft.datagen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.data.models.model.TextureMapping.cube;

public class DRCBlockStateProvider extends BlockStateProvider {

    public DRCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeepRockCraftMod.MOD_ID, exFileHelper);
    }

    public ResourceLocation extend(ResourceLocation rl, String suffix) {
        String var10002 = rl.getNamespace();
        String var10003 = rl.getPath();
        return new ResourceLocation(var10002, var10003 + suffix);
    }

    public void ambientStoneBlock(RegistryObject<Block> block) {
        ResourceLocation z = this.extend(this.blockTexture(block.get()), "_z");
        ResourceLocation nz = this.extend(this.blockTexture(block.get()), "_nz");
        ResourceLocation x = this.extend(this.blockTexture(block.get()), "_x");
        ResourceLocation nx = this.extend(this.blockTexture(block.get()), "_nx");
        ResourceLocation up = this.extend(this.blockTexture(block.get()), "_up");
        ResourceLocation dw = this.extend(this.blockTexture(block.get()), "_dw");
        ModelFile stone = this.models().cube(this.name(block.get()), dw,up,nz,z,x,nx).texture("particle",dw);
        this.getVariantBuilder(block.get())
                .partialState()
                .modelForState().modelFile(stone)
                .addModel();
        this.blockItem(block);
    }

    @Override
    protected void registerStatesAndModels() {
        crossBlock(DRCBlocks.RED_BIG_CRYSTAL);
        blockWithItem(DRCBlocks.MOD_PORTAL);
        blockWithItem(DRCBlocks.DARK_MAGMA_CORE_BLOCK);
        blockWithItem(DRCBlocks.MAGMA_CORE_BLOCK);
        blockWithItem(DRCBlocks.SAND_BLASED_STONE);
        blockWithItem(DRCBlocks.YL_SAND_BLASED_STONE);
        blockWithItem(DRCBlocks.RADIATED_STONE);
        blockWithItem(DRCBlocks.GLACIAL_STONE);
        blockWithItem(DRCBlocks.AZURE_STONE);
        blockWithItem(DRCBlocks.HOLLOW_BOUGH_STONE);
        blockWithItem(DRCBlocks.CRYSTALLINE_STONE);
        blockWithItem(DRCBlocks.WHITE_CRYSTALLINE_STONE);
        blockWithItem(DRCBlocks.FUNGUS_STONE);
        ambientStoneBlockST(DRCBlocks.BIOZONE_STONE);
        ambientStoneBlockST(DRCBlocks.RED_SALT);
        ambientStoneBlockST(DRCBlocks.WINE_SALT);
        ambientStoneBlockST(DRCBlocks.ROSE_SALT);
    }
    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(DeepRockCraftMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void ambientStoneBlockSBT(RegistryObject<Block> block) {
        ResourceLocation sd = this.extend(this.blockTexture(block.get()), "_sd");
        ResourceLocation up = this.extend(this.blockTexture(block.get()), "_up");
        ResourceLocation dw = this.extend(this.blockTexture(block.get()), "_dw");
        ModelFile stone = this.models().cube(this.name(block.get()), dw,up,sd,sd,sd,sd).texture("particle",sd);
        this.getVariantBuilder(block.get())
                .partialState()
                .modelForState().modelFile(stone)
                .addModel();
        this.blockItem(block);
    }
    public void ambientStoneBlockST(RegistryObject<Block> block) {
        ResourceLocation sd = this.extend(this.blockTexture(block.get()), "_sd");
        ResourceLocation up = this.extend(this.blockTexture(block.get()), "_up");
        ModelFile stone = this.models().cube(this.name(block.get()), sd,up,sd,sd,sd,sd).texture("particle",sd);
        this.getVariantBuilder(block.get())
                .partialState()
                .modelForState().modelFile(stone)
                .addModel();
        this.blockItem(block);
    }

    private void crossBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}