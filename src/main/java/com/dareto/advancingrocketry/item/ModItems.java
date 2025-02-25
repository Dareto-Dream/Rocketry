package com.dareto.advancingrocketry.item;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.entity.ModEntities;
import com.dareto.advancingrocketry.fluid.ModFluids;
import com.dareto.advancingrocketry.item.custom.ChiselItem;
import com.dareto.advancingrocketry.item.custom.RocketFuelItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
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

    public static final RegistryObject<Item> CRUDE_OIL_BUCKET = ITEMS.register("crude_oil_bucket",
            () -> new BucketItem(ModFluids.SOURCE_CRUDE_OIL ,new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> SPACEDRONE_SPAWN_EGG = ITEMS.register("spacedrone_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPACE_DRONE, 0x53524b, 0xdac741, new Item.Properties()));

    public static final RegistryObject<Item> CYBORG_SPAWN_EGG = ITEMS.register("cyborg_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CYBORG, 0x53524b, 0x53c741, new Item.Properties()));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
