package dev.stormgrizli.deeprockcraft.registries;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.entity.CrystalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DRCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DeepRockCraftMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CrystalBlockEntity>> CRYSTAL_BE=
            BLOCK_ENTITIES.register("crystals_be", () ->
                    BlockEntityType.Builder.of(CrystalBlockEntity::new,
                            DRCBlocks.CRYSTALS_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
