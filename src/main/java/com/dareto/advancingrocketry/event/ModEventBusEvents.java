package com.dareto.advancingrocketry.event;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.entity.ModEntities;
import com.dareto.advancingrocketry.entity.client.SpaceDroneModel;
import com.dareto.advancingrocketry.entity.custom.SpaceDroneEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdvancingRocketry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SpaceDroneModel.LAYER_LOCATION, SpaceDroneModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SPACE_DRONE.get(), SpaceDroneEntity.createAttributes().build());
    }

}
