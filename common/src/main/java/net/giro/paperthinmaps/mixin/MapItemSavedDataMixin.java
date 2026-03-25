package net.giro.paperthinmaps.mixin;

import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.saveddata.maps.MapDecoration;

@Mixin(MapItemSavedData.class)
public class MapItemSavedDataMixin {

    @Inject(method = "addDecoration", at = @At("HEAD"), cancellable = true)
    private void onAddDecoration(MapDecoration.Type type, net.minecraft.world.level.LevelAccessor level, String id, double x, double z, double rotation, Component name, CallbackInfo ci) {
        if (type == MapDecoration.Type.FRAME) {
            ci.cancel();
        }
    }
}