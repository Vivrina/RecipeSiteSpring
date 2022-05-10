package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Category;
import ru.itis.models.Recipe;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CategoryService;
import ru.itis.services.RecipeService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
    private final RecipeService recipeService;
    private final CategoryService categoryService;

    @GetMapping(value = "?id="+"{categoryId}")
    public ModelAndView getAllRecipeCategory(@PathVariable("categoryId") Long id, ModelAndView modelAndView, Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
            User user = details.getUser();
            modelAndView.addObject("user", user);
        }
        List<Recipe> recipes = new ArrayList<>();
        for (int i=0; i<recipeService.findRecipes().size(); i++){
            if(recipeService.findRecipes().get(i).getCategory() == categoryService.getCategory(id) ){
                recipes.add(recipeService.findRecipes().get(i));
            }

        }
        modelAndView.addObject("recipes", recipes);

        List<Category> categories = categoryService.findCategories();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }
}
