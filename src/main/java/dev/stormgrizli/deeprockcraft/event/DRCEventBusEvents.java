package dev.stormgrizli.deeprockcraft.event;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.registries.DRCEntities;
import dev.stormgrizli.deeprockcraft.entity.custom.GlyphidGruntEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeepRockCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DRCEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(DRCEntities.GRYPHID_GRUNT.get(), GlyphidGruntEntity.createAttributes().build());
    }
}
