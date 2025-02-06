package com.dareto.advancingrocketry.item;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.item.custom.ChiselItem;
import com.dareto.advancingrocketry.item.custom.RocketFuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<Item> STEEL = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROCKET_FUEL = ITEMS.register("rocket_fuel",
            () -> new RocketFuelItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
