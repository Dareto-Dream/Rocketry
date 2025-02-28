package com.dareto.advancingrocketry.datagen;

import com.dareto.advancingrocketry.AdvancingRocketry;
import com.dareto.advancingrocketry.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AdvancingRocketry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FUEL_DISTILLER.get())
                .add(ModBlocks.MODEL_ROCKET.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.FUEL_TANK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                //.add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
        ;
    }
}