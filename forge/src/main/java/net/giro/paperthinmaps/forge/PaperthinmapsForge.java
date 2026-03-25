package net.giro.paperthinmaps.forge;

import net.giro.paperthinmaps.Paperthinmaps;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Paperthinmaps.MOD_ID)
public final class PaperthinmapsForge {
    public PaperthinmapsForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Paperthinmaps.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        Paperthinmaps.init();
    }
}
