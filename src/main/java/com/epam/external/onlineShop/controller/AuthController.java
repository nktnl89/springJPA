package com.epam.external.onlineShop.controller;

import com.epam.external.onlineShop.entity.User;
import com.epam.external.onlineShop.entity.enums.UserRole;
import com.epam.external.onlineShop.exception.NotFoundException;
import com.epam.external.onlineShop.manager.UserManager;
import com.epam.external.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    @Autowired
    private UserManager userManager;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        request.getSession().invalidate();
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        modelAndView.addObject("error", "");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView getNewUser(@Validated User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.getUserByLogin(user.getLogin()) == null) {
            user.setUserRole(UserRole.USER);
            userService.addUser(user);
            modelAndView.addObject("error", "");
            modelAndView.setViewName("redirect:/login");

        } else {
            modelAndView.addObject("error", "Пользователь с таким логином уже существует");
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User currentUser = userService.getUserByLogin(user.getLogin());
        if (currentUser == null) {
            throw new NotFoundException("Пользователя с таким логином не найдено");
        } else {
            if (currentUser.getPassword().equals(user.getPassword())) {
                userManager.setUser(currentUser);
                modelAndView.setViewName("redirect:/home");
            } else {
                modelAndView.addObject("errorMsg", "Пароль неверен");
            }
        }
        return modelAndView;
    }
}
