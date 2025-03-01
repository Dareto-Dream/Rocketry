package com.deltavdevs.advancingrocketry.entity.client;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.entity.custom.CyborgEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CyborgModel<T extends CyborgEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AdvancingRocketry.MOD_ID, "cyborg"), "main");
    private final ModelPart body;
    private final ModelPart legs;
    private final ModelPart leg;
    private final ModelPart leg2;
    private final ModelPart head;
    private final ModelPart arms;
    private final ModelPart arm;
    private final ModelPart arm2;
    private final ModelPart chest;
    private final ModelPart door;
    private final ModelPart door2;

    public CyborgModel(ModelPart root) {
        this.body = root.getChild("body");
        this.legs = this.body.getChild("legs");
        this.leg = this.legs.getChild("leg");
        this.leg2 = this.legs.getChild("leg2");
        this.head = this.body.getChild("head");
        this.arms = this.body.getChild("arms");
        this.arm = this.arms.getChild("arm");
        this.arm2 = this.arms.getChild("arm2");
        this.chest = this.body.getChild("chest");
        this.door = this.chest.getChild("door");
        this.door2 = this.chest.getChild("door2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -34.0F, 3.0F, 12.0F, 17.0F, 0.0F, new CubeDeformation(0.001F))
                .texOffs(48, 31).addBox(-6.0F, -34.0F, -3.0F, 1.0F, 17.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(48, 54).addBox(5.0F, -34.0F, -3.0F, 1.0F, 17.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(48, 17).addBox(-5.0F, -34.0F, -3.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(48, 24).addBox(-5.0F, -18.0F, -3.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -17.0F, 0.0F));

        PartDefinition leg = legs.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

        PartDefinition leg2 = legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(24, 24).addBox(-3.0F, 1.0F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -34.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -32.0F, 0.0F));

        PartDefinition arm = arms.addOrReplaceChild("arm", CubeListBuilder.create().texOffs(0, 47).addBox(-6.0F, -2.0F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, 0.0F));

        PartDefinition arm2 = arms.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(24, 47).addBox(0.0F, -2.0F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, -26.0F, 0.0F));

        PartDefinition door = chest.addOrReplaceChild("door", CubeListBuilder.create().texOffs(62, 31).addBox(-5.0F, -7.0F, 0.0F, 5.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, -3.0F));

        PartDefinition door2 = chest.addOrReplaceChild("door2", CubeListBuilder.create().texOffs(62, 48).addBox(0.0F, -7.0F, 0.0F, 5.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, -3.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(CyborgEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(CyborgAnimations.ANIM_CYBORG_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, CyborgAnimations.ANIM_CYBORG_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
