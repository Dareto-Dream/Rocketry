package com.dareto.advancingrocketry.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import com.dareto.advancingrocketry.fluid.CrudeOilFluid;

public class CrudeOilBlock extends LiquidBlock {
    public CrudeOilBlock() {
        super(() -> CrudeOilFluid.CRUDE_OIL.get(),
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WATER) // MapColor to represent water-like fluid
                        .noCollission()
                        .strength(100.0f)
                        .noLootTable());
    }
}
