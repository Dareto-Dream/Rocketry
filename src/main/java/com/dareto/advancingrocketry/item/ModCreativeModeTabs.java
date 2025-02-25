package com.dareto.advancingrocketry.item;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ROCKET_TOOLS_TAB = CREATIVE_MODE_TABS.register("rocket_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROCKET_FUEL.get()))
                    .title(Component.translatable("creativetab.advancingrocketry.rocket_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ROCKET_FUEL.get());
                        output.accept(ModBlocks.FUEL_TANK.get());

                        output.accept(ModItems.CHISEL.get());


                    }).build());

    public static final RegistryObject<CreativeModeTab> ROCKET_SUPPLIES_TAB = CREATIVE_MODE_TABS.register("rocket_supplies_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .withTabsBefore(ROCKET_TOOLS_TAB.getId())
                    .title(Component.translatable("creativetab.advancingrocketry.rocket_supplies"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STEEL.get());
                        output.accept(ModBlocks.STEEL_BLOCK.get());
                        output.accept(ModBlocks.CHAIR.get());



                    }).build());

    public static final RegistryObject<CreativeModeTab> ROCKET_LIQUID_TAB = CREATIVE_MODE_TABS.register("rocket_liquid_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRUDE_OIL_BUCKET.get()))
                    .withTabsBefore(ROCKET_SUPPLIES_TAB.getId())
                    .title(Component.translatable("creativetab.advancingrocketry.rocket_liquid"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CRUDE_OIL_BUCKET.get());


                    }).build());

    public static final RegistryObject<CreativeModeTab> ROCKETS = CREATIVE_MODE_TABS.register("rockets",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MODEL_ROCKET.get()))
                    .withTabsBefore(ROCKET_LIQUID_TAB.getId())
                    .title(Component.translatable("creativetab.advancingrocketry.rockets"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MODEL_ROCKET.get());



                    }).build());

    public static final RegistryObject<CreativeModeTab> DRONES = CREATIVE_MODE_TABS.register("drones",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPACEDRONE_SPAWN_EGG.get()))
                    .withTabsBefore(ROCKETS.getId())
                    .title(Component.translatable("creativetab.advancingrocketry.drones"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SPACEDRONE_SPAWN_EGG.get());
                        output.accept(ModItems.CYBORG_SPAWN_EGG.get());



                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
