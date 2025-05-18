package dev.stormgrizli.deeprockcraft.registries;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DRCTags {
    public static class  Blocks{
        public static final TagKey<Block> NITRA_REPLACEABLE = tag("nitra_spawns");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(DeepRockCraftMod.MOD_ID, name));
        }
    }
    public static class  Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(DeepRockCraftMod.MOD_ID, name));
        }
    }
}
