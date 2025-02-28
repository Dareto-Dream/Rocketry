package com.dareto.advancingrocketry.block.entity;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<BlockEntityType<FuelDistillerBlockEntity>>  FUEL_DISTILLER_BE =
            BLOCK_ENTITIES.register("fuel_distiller_be",
                    () -> BlockEntityType.Builder.of(FuelDistillerBlockEntity::new,
                            ModBlocks.FUEL_DISTILLER.get()).build(null));

    public static final RegistryObject<BlockEntityType<FuelTankBlockEntity>>  FUEL_TANK_BE =
            BLOCK_ENTITIES.register("fuel_tank_be",
                    () -> BlockEntityType.Builder.of(FuelTankBlockEntity::new,
                            ModBlocks.FUEL_TANK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
