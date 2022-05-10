package ru.itis.services;

import ru.itis.dto.RecipeDto;
import ru.itis.models.Category;
import ru.itis.models.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe addRecipe(RecipeDto recipeDto);
    List<Recipe> findRecipes();
}
