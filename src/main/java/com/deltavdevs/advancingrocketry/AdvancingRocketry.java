package com.deltavdevs.advancingrocketry;

import com.deltavdevs.advancingrocketry.block.ModBlocks;
import com.deltavdevs.advancingrocketry.block.entity.ModBlockEntities;
import com.deltavdevs.advancingrocketry.block.entity.renderer.PedestalBlockEntityRenderer;
import com.deltavdevs.advancingrocketry.entity.ModEntities;
import com.deltavdevs.advancingrocketry.entity.client.ChairRenderer;
import com.deltavdevs.advancingrocketry.entity.client.CyborgRenderer;
import com.deltavdevs.advancingrocketry.entity.client.SpaceDroneRenderer;
import com.deltavdevs.advancingrocketry.fluid.ModFluidTypes;
import com.deltavdevs.advancingrocketry.fluid.ModFluids;
import com.deltavdevs.advancingrocketry.item.ModCreativeModeTabs;
import com.deltavdevs.advancingrocketry.item.ModItems;
import com.deltavdevs.advancingrocketry.recipe.ModRecipes;
import com.deltavdevs.advancingrocketry.screen.custom.FuelDistillerScreen;
import com.deltavdevs.advancingrocketry.screen.ModMenuTypes;
import com.deltavdevs.advancingrocketry.screen.custom.BiomassProcessorScreen;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
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
        ModRecipes.register(modEventBus);

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
            MenuScreens.register(ModMenuTypes.BIOMASS_PROCESSOR_MENU.get(), BiomassProcessorScreen::new);
            //MenuScreens.register(ModMenuTypes.FUEL_TANK_MENU.get(), FuelTankScreen::new);
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }
    }
}

/*
You know sometimes when im lonely, i stick it in bologna
And sometimes when im lovesick, i rub it out on my own d*ck
I like to look at the wall, as i rub out my ball
 */
