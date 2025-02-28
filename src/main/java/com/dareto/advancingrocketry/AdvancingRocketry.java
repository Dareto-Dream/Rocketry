package com.dareto.advancingrocketry;

import com.dareto.advancingrocketry.block.ModBlocks;
import com.dareto.advancingrocketry.block.entity.ModBlockEntities;
import com.dareto.advancingrocketry.entity.ModEntities;
import com.dareto.advancingrocketry.entity.client.ChairRenderer;
import com.dareto.advancingrocketry.entity.client.CyborgRenderer;
import com.dareto.advancingrocketry.entity.client.SpaceDroneRenderer;
import com.dareto.advancingrocketry.fluid.ModFluidTypes;
import com.dareto.advancingrocketry.fluid.ModFluids;
import com.dareto.advancingrocketry.item.ModCreativeModeTabs;
import com.dareto.advancingrocketry.item.ModItems;
import com.dareto.advancingrocketry.screen.FuelDistillerScreen;
import com.dareto.advancingrocketry.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AdvancingRocketry.MOD_ID)
public class AdvancingRocketry {
    public static final String MOD_ID = "advancingrocketry";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AdvancingRocketry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("AdvancingRocketry server is starting...");
    }

    @Mod.EventBusSubscriber(modid = AdvancingRocketry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_CRUDE_OIL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_CRUDE_OIL.get(), RenderType.translucent());

            EntityRenderers.register(ModEntities.SPACE_DRONE.get(), SpaceDroneRenderer::new);
            EntityRenderers.register(ModEntities.CYBORG.get(), CyborgRenderer::new);
            EntityRenderers.register(ModEntities.CHAIR.get(), ChairRenderer::new);

            MenuScreens.register(ModMenuTypes.FUEL_DISTILLER_MENU.get(), FuelDistillerScreen::new);
        }
    }
}

/*
You know sometimes when im lonely, i stick it in bologna
And sometimes when im lovesick, i rub it out on my own d*ck
I like to look at the wall, as i rub out my ball
 */
