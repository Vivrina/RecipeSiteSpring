package ru.itis.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.UserDto;
import ru.itis.exception.UserAlreadyExistException;
import ru.itis.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/signUp")
    public String signUpPage() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public ModelAndView signUpUser(ModelAndView modelAndView, UserDto userDto) {
        try {
            userService.signUp(userDto);
        } catch (UserAlreadyExistException e) {
            modelAndView.addObject("registrationStatus", "Пользователь с таким email уже существует");
            modelAndView.setViewName("signUp");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/signIn");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signIn")
    public String getLoginForm(HttpServletRequest request, ModelMap model) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Неправильный логин или пароль");
        }
        return "signIn";
    }
}
