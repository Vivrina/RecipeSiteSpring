package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.RecipeDto;
import ru.itis.models.Category;
import ru.itis.models.Recipe;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CategoryService;
import ru.itis.services.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/addRecipe")
    public ModelAndView addAnnouncement(RecipeDto recipeDto, ModelAndView modelAndView, Authentication authentication) {
        if (authentication == null) {
            modelAndView.setViewName("redirect:/signIn");
        } else {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
            User user = details.getUser();
            recipeDto.setUserId(user.getId());
            Recipe recipe = recipeService.addRecipe(recipeDto);
            if(recipe != null) {
                modelAndView.setViewName("redirect:/image/upload/"+recipe.getId());
            } else {
                modelAndView.setViewName("redirect:/profile");
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/addRecipe")
    public ModelAndView addAnnouncement(ModelAndView modelAndView, Authentication authentication) {
        if (authentication == null) {
            modelAndView.setViewName("redirect:/signIn");
        } else {
            List<Category> category = categoryService.findCategories();
            modelAndView.addObject("category", category);
            modelAndView.setViewName("addRecipe");
        }
        return modelAndView;
    }



}
