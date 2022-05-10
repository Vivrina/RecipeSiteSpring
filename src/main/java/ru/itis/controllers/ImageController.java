package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Image;
import ru.itis.services.ImageService;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/image")
    public ModelAndView upload(MultipartFile file, Long announcementId, Long accountId,
                               ModelAndView modelAndView) {
        if(accountId != null) {
            imageService.upload(file, Image.Type.USER, accountId);
            modelAndView.setViewName("redirect:/profile/" + accountId);
        } else if(announcementId != null) {
            imageService.upload(file, Image.Type.RECIPE, announcementId);
            modelAndView.setViewName("redirect:/announcement/" + announcementId);
        } else {
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    @GetMapping("/image")
    public void getFile(String uuidName, HttpServletResponse response) {
        imageService.getImage(uuidName, response);
    }
}
