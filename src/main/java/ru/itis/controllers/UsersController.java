package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.services.UserService;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public ModelAndView getProfile(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        if (authentication == null) {
            modelAndView.setViewName("redirect:/signIn");
            return modelAndView;
        }
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
