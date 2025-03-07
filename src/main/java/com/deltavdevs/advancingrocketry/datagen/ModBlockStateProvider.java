package com.deltavdevs.advancingrocketry.datagen;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AdvancingRocketry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.BIOMASS_PROCESSOR);

        simpleBlockWithItem(ModBlocks.FUEL_DISTILLER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/fuel_distiller")));

        simpleBlockWithItem(ModBlocks.FUEL_TANK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/fuel_tank_empty")));

        simpleBlock(ModBlocks.CRUDE_OIL_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/crude_oil_block")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}