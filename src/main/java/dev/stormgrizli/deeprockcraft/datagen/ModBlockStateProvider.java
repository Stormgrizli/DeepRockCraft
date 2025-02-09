package dev.stormgrizli.deeprockcraft.datagen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.data.models.model.TextureMapping.cube;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
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
        ModelFile stone = this.models().cube(this.name(block.get()), dw,up,nz,z,x,nx);
        this.getVariantBuilder(block.get())
                .partialState()
                .modelForState().modelFile(stone)
                .addModel();
        this.blockItem(block);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MOD_PORTAL);
        ambientStoneBlock(ModBlocks.RED_SALT);
        ambientStoneBlock(ModBlocks.WINE_SALT);
        ambientStoneBlock(ModBlocks.ROSE_SALT);
        ambientStoneBlockSBT(ModBlocks.CRYSTALLINE_STONE);
        ambientStoneBlockSBT(ModBlocks.CRYSTALLINE_STONE_SLAB);
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
        ModelFile stone = this.models().cube(this.name(block.get()), up,dw,sd,sd,sd,sd);
        this.getVariantBuilder(block.get())
                .partialState()
                .modelForState().modelFile(stone)
                .addModel();
        this.blockItem(block);
    }
}