package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class StartController {
    private final RecipeService recipeService;
    private final CategoryService categoryService;


    @GetMapping(value = "/start")
    public ModelAndView getStart(ModelAndView modelAndView, Authentication authentication) {
        //if (authentication != null) {
//            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
//            User user = details.getUser();
//            modelAndView.addObject("user", user);
        //}

        List<Recipe> recipes = recipeService.findRecipes();
        List<Recipe> recipesTwo = new ArrayList<>();
        if(recipes.size()>=2){
            recipesTwo.add(recipes.get(0));
            recipesTwo.add(recipes.get(1));
            recipes.remove(0);
            recipes.remove(0);
        }
        modelAndView.addObject("recipesTwo", recipesTwo);
        modelAndView.addObject("recipes", recipes);


        List<Category> categories = categoryService.findCategories();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @GetMapping(value = "/allRecipe")
    public ModelAndView getAllRecipe(ModelAndView modelAndView, Authentication authentication) {
//        if (authentication != null) {
//            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
//            User user = details.getUser();
//            modelAndView.addObject("user", user);
//        }

        List<Recipe> recipes = recipeService.findRecipes();
        modelAndView.addObject("recipes", recipes);


        List<Category> categories = categoryService.findCategories();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }



}
