package com.deltavdevs.advancingrocketry.entity.client;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.entity.custom.SpaceDroneEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpaceDroneRenderer extends MobRenderer<SpaceDroneEntity, SpaceDroneModel<SpaceDroneEntity>> {
    public SpaceDroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SpaceDroneModel<>(pContext.bakeLayer(SpaceDroneModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(SpaceDroneEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(AdvancingRocketry.MOD_ID, "textures/entity/spacedrone/space_drone_gray.png");
    }

    @Override
    public void render(SpaceDroneEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f,0.5f,0.5f);
        } else {
            pPoseStack.scale(1f,1f,1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
