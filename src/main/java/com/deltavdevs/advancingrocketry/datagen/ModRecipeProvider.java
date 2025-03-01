package com.deltavdevs.advancingrocketry.datagen;

import com.deltavdevs.advancingrocketry.AdvancingRocketry;
import com.deltavdevs.advancingrocketry.block.ModBlocks;
import com.deltavdevs.advancingrocketry.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> STEEL_SMELTABLES = List.of(Items.IRON_INGOT);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STEEL.get())
                .unlockedBy(getHasName(ModItems.STEEL.get()), has(ModItems.STEEL.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" C ")
                .define('A', ModItems.STEEL.get())
                .define('B', Items.IRON_INGOT)
                .define('C', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL.get()), has(ModItems.STEEL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FUEL_TANK.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModItems.STEEL.get())
                .define('B', Items.GLASS_PANE)
                .unlockedBy(getHasName(ModItems.STEEL.get()), has(ModItems.STEEL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHAIR.get())
                .pattern("A  ")
                .pattern("AAA")
                .pattern("B B")
                .define('A', ModItems.STEEL.get())
                .define('B', Items.OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.STEEL.get()), has(ModItems.STEEL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MODEL_ROCKET.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("CAC")
                .define('A', ModBlocks.STEEL_BLOCK.get())
                .define('B', ModBlocks.FUEL_DISTILLER.get())
                .define('C', Items.IRON_BARS)
                .unlockedBy(getHasName(ModItems.STEEL.get()), has(ModItems.STEEL.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL.get(), 0.25f, 200, "steel");
        oreBlasting(pRecipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL.get(), 0.25f, 100, "steel");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AdvancingRocketry.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}