package com.deltavdevs.advancingrocketry.block;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.block.custom.ChairBlock;
import com.deltavdevs.advancingrocketry.block.custom.FuelDistillerBlock;
import com.deltavdevs.advancingrocketry.block.custom.FuelTankBlock;
import com.deltavdevs.advancingrocketry.block.custom.RocketBaseBlock;
import com.deltavdevs.advancingrocketry.fluid.ModFluids;
import com.deltavdevs.advancingrocketry.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

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

    // Fuel Distiller
    public static final RegistryObject<Block> FUEL_DISTILLER = registerBlock("fuel_distiller",
            () -> new FuelDistillerBlock(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));

    // Fuel Tank
    public static final RegistryObject<Block> FUEL_TANK = registerBlock("fuel_tank",
            () -> new FuelTankBlock(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));

    // Crude Oil
    public static final RegistryObject<LiquidBlock> CRUDE_OIL_BLOCK = BLOCKS.register("crude_oil_block",
            () -> new LiquidBlock(ModFluids.SOURCE_CRUDE_OIL, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    // the chair
    public static final RegistryObject<Block> CHAIR = registerBlock("chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.NETHERITE_BLOCK)));

    // the Rocket Base
    public static final RegistryObject<Block> MODEL_ROCKET = registerBlock("model_rocket",
            () -> new RocketBaseBlock(BlockBehaviour.Properties.of().noOcclusion()));


    //Register blocks
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // 🔗 Register Block Items
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    static {
        // Register block items for each block
        registerBlockItem("steel_block", STEEL_BLOCK);
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}