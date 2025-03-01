package com.deltavdevs.advancingrocketry.event;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.entity.ModEntities;
import com.deltavdevs.advancingrocketry.entity.client.CyborgModel;
import com.deltavdevs.advancingrocketry.entity.client.SpaceDroneModel;
import com.deltavdevs.advancingrocketry.entity.custom.CyborgEntity;
import com.deltavdevs.advancingrocketry.entity.custom.SpaceDroneEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdvancingRocketry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SpaceDroneModel.LAYER_LOCATION, SpaceDroneModel::createBodyLayer);
        event.registerLayerDefinition(CyborgModel.LAYER_LOCATION, CyborgModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SPACE_DRONE.get(), SpaceDroneEntity.createAttributes().build());
        event.put(ModEntities.CYBORG.get(), CyborgEntity.createAttributes().build());
    }

}
