package dev.stormgrizli.deeprockcraft.worldgen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.worldgen.features.DRCSpikeFeature;
import dev.stormgrizli.deeprockcraft.worldgen.features.Spikecfg;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DRCFeature {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeepRockCraftMod.MOD_ID);

    public static final RegistryObject<Feature<Spikecfg>> CRYSTAL_SPIKE = FEATURES.register("crystal_spike", () -> new DRCSpikeFeature(Spikecfg.CODEC));

}
