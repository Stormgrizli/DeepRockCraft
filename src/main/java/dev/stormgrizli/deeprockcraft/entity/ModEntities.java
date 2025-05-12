package dev.stormgrizli.deeprockcraft.entity;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;


import dev.stormgrizli.deeprockcraft.entity.custom.GlyphidGruntEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeepRockCraftMod.MOD_ID);

    public static final RegistryObject<EntityType<GlyphidGruntEntity>> GRYPHID_GRUNT =
            ENTITY_TYPES.register("glyphid_grunt", () -> EntityType.Builder.of(GlyphidGruntEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 1f).build("glyphid_grunt"));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
