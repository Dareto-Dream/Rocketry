package com.dareto.advancingrocketry.block;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.fluid.ModFluids;
import com.dareto.advancingrocketry.item.ModItems;
import com.mojang.authlib.properties.Property;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles all block registrations for the Advancing Rocketry mod.
 */
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancingRocketry.MOD_ID);

    // Steel Block
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)));

    // Fuel Tank
    public static final RegistryObject<Block> FUEL_TANK = BLOCKS.register("fuel_tank",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));

    // Crude Oil Block
    public static final RegistryObject<LiquidBlock> CRUDE_OIL_BLOCK = BLOCKS.register("crude_oil_block",
            () -> new LiquidBlock(() -> ModFluids.CRUDE_OIL.get(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WATER)
                            .noCollission()
                            .strength(100.0f)
                            .noLootTable()
                            .liquid()));



    // 🔗 Register Block Items
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    static {
        // Register block items for each block
        registerBlockItem("steel_block", STEEL_BLOCK);
        registerBlockItem("fuel_tank", FUEL_TANK);
        registerBlockItem("crude_oil_block", CRUDE_OIL_BLOCK);
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}