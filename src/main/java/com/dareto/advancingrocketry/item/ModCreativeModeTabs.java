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


                    }).build());

    public static final RegistryObject<CreativeModeTab> ROCKET_SUPPLIES_TAB = CREATIVE_MODE_TABS.register("rocket_supplies_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .withTabsBefore(ROCKET_TOOLS_TAB.getId())
                    .title(Component.translatable("creativetab.advancingrocketry.rocket_supplies"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STEEL.get());
                        output.accept(ModBlocks.STEEL_BLOCK.get());


                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}