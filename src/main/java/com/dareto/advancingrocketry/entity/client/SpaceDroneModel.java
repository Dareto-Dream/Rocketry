package com.dareto.advancingrocketry.entity.client;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.entity.custom.SpaceDroneEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SpaceDroneModel<T extends SpaceDroneEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AdvancingRocketry.MOD_ID, "space_drone"), "main");
    private final ModelPart bone;
    private final ModelPart propellars;
    private final ModelPart body;
    private final ModelPart eyes;

    public SpaceDroneModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.propellars = this.bone.getChild("propellars");
        this.body = this.bone.getChild("body");
        this.eyes = bone.getChild("body").getChild("eyes");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition propellars = bone.addOrReplaceChild("propellars", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = propellars.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-7.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.001F))
                .texOffs(0, 16).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 20).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition eyes = body.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(32, 0).addBox(-5.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 26).addBox(-5.0F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition eyelids = eyes.addOrReplaceChild("eyelids", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition eyelid = eyelids.addOrReplaceChild("eyelid", CubeListBuilder.create().texOffs(32, 8).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.11F)), PartPose.offset(-4.0F, -6.0F, 0.0F));

        PartDefinition eyelid2 = eyelids.addOrReplaceChild("eyelid2", CubeListBuilder.create().texOffs(32, 14).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(-4.0F, -2.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arm = arms.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -4.0F));

        PartDefinition top = arm.addOrReplaceChild("top", CubeListBuilder.create().texOffs(18, 16).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bottom = top.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(18, 23).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition hand = bottom.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -1.0F));

        PartDefinition cube_r2 = hand.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 39).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r3 = hand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition arm2 = arms.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition top2 = arm2.addOrReplaceChild("top2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bottom2 = top2.addOrReplaceChild("bottom2", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition hand2 = bottom2.addOrReplaceChild("hand2", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -1.0F));

        PartDefinition cube_r4 = hand2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r5 = hand2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(SpaceDroneEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(SpaceDroneAnimations.ANIM_SPACEDRONE_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, SpaceDroneAnimations.ANIM_SPACEDRONE_HOVER, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

        this.bone.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.bone.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
