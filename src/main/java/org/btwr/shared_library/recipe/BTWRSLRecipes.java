package org.btwr.shared_library.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.btwr.shared_library.BTWRSLMod;

public class BTWRSLRecipes {
    public static final DisabledRecipe.Serializer DISABLED_RECIPE_SERIALIZER = new DisabledRecipe.Serializer();
    public static final RecipeType<DisabledRecipe> DISABLED_RECIPE_TYPE = new RecipeType<>() {};

    public static void register() {
        // Disabled recipe used for disabling existing recipes
        registerRecipe("disabled", DISABLED_RECIPE_TYPE, DISABLED_RECIPE_SERIALIZER);
    }

    private static void registerRecipe(String path, RecipeType<?> type, RecipeSerializer<?> serializer) {
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(BTWRSLMod.MOD_ID, path), type);
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(BTWRSLMod.MOD_ID, path), serializer);
    }
}