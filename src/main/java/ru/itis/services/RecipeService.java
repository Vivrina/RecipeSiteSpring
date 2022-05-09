package ru.itis.services;

import ru.itis.dto.RecipeDto;
import ru.itis.models.Recipe;

public interface RecipeService {
    Recipe addRecipe(RecipeDto recipeDto);
}
