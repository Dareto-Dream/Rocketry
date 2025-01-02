package com.dareto.advancingrocketry.fluid;

import com.dareto.advancingrocketry.AdvancingRocketry;
import net.minecraftforge.fluids.FluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.Minecraft;

public class CrudeOilFluidType extends FluidType {
    public CrudeOilFluidType() {
        super(FluidType.Properties.create()
                .descriptionId("block.advancingrocketry.crude_oil_block")
                .density(1000)
                .viscosity(2000)
                .fallDistanceModifier(0.5f)
                .motionScale(0.008)
                .lightLevel(0)
        );
    }
}
