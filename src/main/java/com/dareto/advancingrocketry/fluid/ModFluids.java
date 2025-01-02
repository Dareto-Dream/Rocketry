package com.dareto.advancingrocketry.fluid;

import com.dareto.advancingrocketry.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.item.ModItems;

public class ModFluids {
    /*public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<Fluid> CRUDE_OIL = FLUIDS.register("steel_block", );*/

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, AdvancingRocketry.MOD_ID);

    public static final DeferredRegister<net.minecraftforge.fluids.FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<net.minecraftforge.fluids.FluidType> CRUDE_OIL_TYPE = FLUID_TYPES.register("crude_oil_block",
            () -> new CrudeOilFluidType());

    public static final RegistryObject<ForgeFlowingFluid.Source> CRUDE_OIL = FLUIDS.register("crude_oil_still",
            () -> new ForgeFlowingFluid.Source(ModFluids.CRUDE_OIL_PROPERTIES));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> FLOWING_CRUDE_OIL = FLUIDS.register("crude_oil_flow",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CRUDE_OIL_PROPERTIES));

    public static final ForgeFlowingFluid.Properties CRUDE_OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> CRUDE_OIL_TYPE.get(),
            () -> CRUDE_OIL.get(),
            () -> FLOWING_CRUDE_OIL.get())
            .bucket(() -> ModItems.CRUDE_OIL_BUCKET.get())
            .block(() -> (LiquidBlock) ModBlocks.CRUDE_OIL_BLOCK.get())
            .explosionResistance(100.0f)
            .tickRate(30);



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}
