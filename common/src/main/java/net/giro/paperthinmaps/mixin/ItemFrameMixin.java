package net.giro.paperthinmaps.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrameRenderer.class)
public class ItemFrameMixin {

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(ItemFrame entity, float f, float g, PoseStack poseStack, MultiBufferSource buffer, int i, CallbackInfo ci) {
        if (entity.getItem().is(Items.FILLED_MAP)) {
            Direction dir = entity.getDirection();
            float adj = -0.0077f;

            switch (dir) {
                case NORTH -> poseStack.translate(0, 0, -adj);
                case SOUTH -> poseStack.translate(0, 0, adj);
                case EAST  -> poseStack.translate(adj, 0, 0);
                case WEST  -> poseStack.translate(-adj, 0, 0);
                case UP    -> poseStack.translate(0, adj, 0);
                case DOWN  -> poseStack.translate(0, -adj, 0);
            }

            if (!entity.isInvisible()) {
                entity.setInvisible(true);
            }
        } else if (entity.isInvisible()) {
            entity.setInvisible(false);
        }
    }
}