package com.deltavdevs.advancingrocketry.recipe;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AdvancingRocketry.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, AdvancingRocketry.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BiomassProcessorRecipe>> BIOMASS_PROCESSOR_SERIALIZER =
            SERIALIZERS.register("biomass_processor", BiomassProcessorRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<BiomassProcessorRecipe>> BIOMASS_PROCESSOR_TYPE =
            TYPES.register("biomass_processor", () -> new RecipeType<BiomassProcessorRecipe>() {
                @Override
                public String toString() {
                    return "biomass_processor";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}