package net.giro.paperthinmaps.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.client.gui.MapRenderer$MapInstance")
public class MapInstanceMixin {
    @Inject(method = "draw", at = @At("HEAD"), remap = false)
    private void onDraw(PoseStack poseStack, MultiBufferSource bufferSource, boolean active, int packedLight, CallbackInfo ci) {
        if (active) {
            poseStack.scale(1.0F, 1.0F, 0.001F);
        }
    }
}