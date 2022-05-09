package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
