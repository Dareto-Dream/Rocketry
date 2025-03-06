package com.deltavdevs.advancingrocketry.screen;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.screen.custom.BiomassProcessorMenu;
import com.deltavdevs.advancingrocketry.screen.custom.FuelDistillerMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<MenuType<FuelDistillerMenu>> FUEL_DISTILLER_MENU =
            registerMenuType("fuel_distiller_menu", FuelDistillerMenu::new);

    public static final RegistryObject<MenuType<BiomassProcessorMenu>> BIOMASS_PROCESSOR_MENU =
            MENUS.register("biomass_processor_menu", () -> IForgeMenuType.create(BiomassProcessorMenu::new));


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
