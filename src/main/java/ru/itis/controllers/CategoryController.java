package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private  RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{categoryId}")
    public ModelAndView getAllRecipeCategory(@PathVariable("categoryId") Long id, ModelAndView modelAndView, Authentication authentication) {
//        if (authentication != null) {
//            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
//            User user = details.getUser();
//            modelAndView.addObject("user", user);
//        }
        List<Recipe> recipes = recipeService.findByCategoryId(id);
        modelAndView.addObject("recipes", recipes);

        List<Category> categories = categoryService.findCategories();
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("category");
        return modelAndView;
    }
}
