package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.RecipeDto;
import ru.itis.models.Category;
import ru.itis.models.Recipe;
import ru.itis.models.User;
import ru.itis.repositories.CategoryRepository;
import ru.itis.repositories.RecipeRepository;
import ru.itis.repositories.UserRepository;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Recipe addRecipe(RecipeDto recipeDto) {
        User user = userRepository.getById(recipeDto.getUserId());
        Category category = categoryRepository.getById(recipeDto.getCategoryId());
        Recipe recipe = Recipe.builder()
                .name(recipeDto.getName())
                .user(user)
                .category(category)
                .description(recipeDto.getDescription())
                .fileName(recipeDto.getFileName())
                .created(new Date())
                .build();
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findRecipes() {
        return recipeRepository.findAll();
    }


}
