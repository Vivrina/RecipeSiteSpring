package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Category;
import ru.itis.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findRecipesByCategory(Category category);
    Optional<Recipe> findRecipeById(Long id);
}
