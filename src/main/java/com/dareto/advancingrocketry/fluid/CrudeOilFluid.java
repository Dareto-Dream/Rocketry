package com.dareto.advancingrocketry.fluid;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.item.ModItems;
import com.dareto.advancingrocketry.block.ModBlocks;

public class CrudeOilFluid {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, AdvancingRocketry.MOD_ID);
    public static final DeferredRegister<net.minecraftforge.fluids.FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<net.minecraftforge.fluids.FluidType> CRUDE_OIL_TYPE = FLUID_TYPES.register("crude_oil_block",
            () -> new CrudeOilFluidType());

    public static final RegistryObject<ForgeFlowingFluid.Source> CRUDE_OIL = FLUIDS.register("crude_oil_still",
            () -> new ForgeFlowingFluid.Source(CrudeOilFluid.CRudeOilProperties.PROPERTIES));

    public static final RegistryObject<ForgeFlowingFluid.Flowing> FLOWING_CRUDE_OIL = FLUIDS.register("crude_oil_flow",
            () -> new ForgeFlowingFluid.Flowing(CrudeOilFluid.CRudeOilProperties.PROPERTIES));

    public static final RegistryObject<Item> CRUDE_OIL_BUCKET = ModItems.ITEMS.register("crude_oil_bucket",
            () -> new net.minecraft.world.item.BucketItem(() -> CRUDE_OIL.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(net.minecraft.world.item.Items.BUCKET)));

    public static class CRudeOilProperties {
        public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
                () -> CRUDE_OIL_TYPE.get(),
                () -> CRUDE_OIL.get(),
                () -> FLOWING_CRUDE_OIL.get())
                .bucket(() -> CRUDE_OIL_BUCKET.get())
                .block(() -> (LiquidBlock) ModBlocks.CRUDE_OIL_BLOCK.get())
                .explosionResistance(100.0f)
                .tickRate(30);
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}
