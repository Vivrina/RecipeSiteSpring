package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.dto.RecipeDto;
import ru.itis.models.Category;
import ru.itis.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe addRecipe(RecipeDto recipeDto);
    List<Recipe> findRecipes();
    Recipe findRecipe(Long id);
    List<Recipe> findByCategoryId(Long id);
    void loadImage(MultipartFile multipart, Long id);
}
