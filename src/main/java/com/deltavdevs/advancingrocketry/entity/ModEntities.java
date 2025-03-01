package com.deltavdevs.advancingrocketry.entity;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.entity.custom.ChairEntity;
import com.deltavdevs.advancingrocketry.entity.custom.CyborgEntity;
import com.deltavdevs.advancingrocketry.entity.custom.SpaceDroneEntity;
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

    public static final RegistryObject<EntityType<CyborgEntity>> CYBORG =
            ENTITY_TYPES.register("cyborg", () -> EntityType.Builder.of(CyborgEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 3f).build("cyborg"));

    public static final RegistryObject<EntityType<ChairEntity>> CHAIR =
            ENTITY_TYPES.register("chair_entity", () -> EntityType.Builder.of(ChairEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f).build("chair_entity"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
