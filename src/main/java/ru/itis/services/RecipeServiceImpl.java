package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
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
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageService imageService;

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

    @Override
    public List<Recipe> findByCategoryId(Long id) {
        Category category = categoryRepository.getById(id);
        return recipeRepository.findRecipesByCategory(category);
    }

    @Override
    @Transactional
    public void loadImage(MultipartFile multipart, Long id) {
        String filename = imageService.upload(multipart);

        Recipe recipe = recipeRepository.getById(id);
        recipe.setFileName(filename);
        recipeRepository.save(recipe);
    }
}
