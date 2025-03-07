package com.deltavdevs.advancingrocketry.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record BiomassProcessorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<BiomassProcessorRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    // read in JSON File --> turns into new BiomassProcessorRecipe

    @Override
    public boolean matches(BiomassProcessorRecipeInput pInput, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItem.test(pInput.getItem(0));
    }

    @Override
    public ItemStack assemble(BiomassProcessorRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.BIOMASS_PROCESSOR_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BIOMASS_PROCESSOR_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<BiomassProcessorRecipe> {
        public static final MapCodec<BiomassProcessorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(BiomassProcessorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(BiomassProcessorRecipe::output)
        ).apply(inst, BiomassProcessorRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BiomassProcessorRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, BiomassProcessorRecipe::inputItem,
                        ItemStack.STREAM_CODEC, BiomassProcessorRecipe::output,
                        BiomassProcessorRecipe::new);

        @Override
        public MapCodec<BiomassProcessorRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BiomassProcessorRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}