package com.dareto.advancingrocketry.entity;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.entity.custom.SpaceDroneEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<EntityType<SpaceDroneEntity>> SPACE_DRONE =
            ENTITY_TYPES.register("space_drone", () -> EntityType.Builder.of(SpaceDroneEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.75f).build("space_drone"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
