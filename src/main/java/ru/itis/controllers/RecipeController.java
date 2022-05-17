package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.CommentDto;
import ru.itis.dto.RateDto;
import ru.itis.dto.RecipeDto;
import ru.itis.models.*;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CategoryService;
import ru.itis.services.CommentService;
import ru.itis.services.RateService;
import ru.itis.services.RecipeService;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RateService rateService;

    @PostMapping(value = "/addRecipe")
    public ModelAndView addRecipe(RecipeDto recipeDto, ModelAndView modelAndView, Authentication authentication) {
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
    public ModelAndView addRecipe(ModelAndView modelAndView, Authentication authentication) {
        if (authentication == null) {
            modelAndView.setViewName("redirect:/signIn");
        } else {
            List<Category> category = categoryService.findCategories();
            modelAndView.addObject("category", category);
            modelAndView.setViewName("addRecipe");
        }
        return modelAndView;
    }
    @GetMapping(value = "recipe/{recipeId}")
    public ModelAndView getRecipe(@PathVariable("recipeId") Long id,ModelAndView modelAndView, Authentication authentication) {
        if (recipeService.findRecipe(id)!=null){
            Recipe recipe =recipeService.findRecipe(id);
            if (authentication != null) {
                System.out.println("В аккаунте");
                UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
                User user = details.getUser();
                modelAndView.addObject("user", user);
                int rateValue = 0;
                int count = 0;
                for (Rate rate : user.getRates()){
                    if(rate.getRecipe().getId().equals(recipe.getId())){
                        rateValue = rate.getValue();
                        count++;
                        break;
                    }
                }
                if(count == 0){
                    System.out.println("Нет оценок");
                    modelAndView.addObject("isRated", true);
                } else {
                    System.out.println("Есть оценки");
                    modelAndView.addObject("rateValue", rateValue);
                }
            }else {
                System.out.println("Не в аккаунте");
            }
            modelAndView.addObject("recipe", recipe);
        } else {
            modelAndView.setViewName("redirect:/start");

        }


        List<Comment> comments = commentService.findByRecipeId(id);
        List<Category> categories = categoryService.findCategories();
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("recipe");
        return modelAndView;
    }

    @PostMapping(value = "/recipe/{recipeId}/addComment")
    public ModelAndView addComment(@PathVariable("recipeId") Long id, CommentDto commentDto, ModelAndView modelAndView, Authentication authentication) {
        if (authentication == null){
            modelAndView.setViewName("redirect:/signIn");
        } else {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
            User user = details.getUser();
            commentDto.setUserId(user.getId());
            if (recipeService.findRecipe(id)!=null){
                Recipe recipe =recipeService.findRecipe(id);
                commentDto.setRecipeId(recipe.getId());
                Comment comment = commentService.addComment(commentDto);
            } else {
                modelAndView.setViewName("redirect:/start");

            }
            modelAndView.setViewName("redirect:/recipe/{recipeId}");
        }
        return modelAndView;
    }


    @PostMapping(value = "/recipe/{recipeId}/rate")
    public ModelAndView addValueRate(@PathVariable("recipeId") Long id, RateDto rateDto, ModelAndView modelAndView, Authentication authentication) {
        if (authentication == null){
            modelAndView.setViewName("redirect:/signIn");
        } else {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
            User user = details.getUser();
            rateDto.setUserId(user.getId());
            if (recipeService.findRecipe(id)!=null){
                Recipe recipe =recipeService.findRecipe(id);
                rateDto.setRecipeId(recipe.getId());
                Rate rate = rateService.addRate(rateDto);
            } else {
                modelAndView.setViewName("redirect:/start");

            }
            modelAndView.setViewName("redirect:/recipe/{recipeId}");
        }
        return modelAndView;
    }

//    @GetMapping(value = "recipe")
//    public ModelAndView getRecipe(ModelAndView modelAndView, Authentication authentication) {
//        if (authentication != null) {
//            UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
//            User user = details.getUser();
//            modelAndView.addObject("user", user);
//        }
////        List<Recipe> recipes = recipeService.findByCategoryId(id);
////        modelAndView.addObject("recipes", recipes);
//
//        List<Category> categories = categoryService.findCategories();
//        modelAndView.addObject("categories", categories);
//        modelAndView.setViewName("recipe");
//        return modelAndView;
//    }


}
