package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Image;
import ru.itis.services.ImageService;
import ru.itis.services.RecipeService;
import ru.itis.services.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/image")
    public ModelAndView upload(@RequestParam("multipart") MultipartFile multipart, Long recipe_id, ModelAndView modelAndView) {
        recipeService.loadImage(multipart, recipe_id);
        modelAndView.setViewName("redirect:/start");
        return modelAndView;
    }

    @GetMapping("/image")
    public void getFile(String name, HttpServletResponse response) {
        imageService.addFileToResponse(name, response);
    }

    @GetMapping("/image/upload/{recipe_id}")
    public ModelAndView getImageUploadPage(@PathVariable("recipe_id") Long recipe_id, ModelAndView modelAndView) {
        modelAndView.addObject("recipe_id", recipe_id);
        modelAndView.setViewName("upload");
        return modelAndView;
    }
}
