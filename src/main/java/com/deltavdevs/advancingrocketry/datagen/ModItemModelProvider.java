package com.deltavdevs.advancingrocketry.datagen;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdvancingRocketry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL.get());
        basicItem(ModItems.CHISEL.get());

        basicItem(ModItems.ROCKET_FUEL.get());
        basicItem(ModItems.CRUDE_OIL_BUCKET.get());

        withExistingParent(ModItems.SPACEDRONE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CYBORG_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}