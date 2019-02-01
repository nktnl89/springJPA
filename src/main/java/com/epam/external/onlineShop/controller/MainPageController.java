package com.epam.external.onlineShop.controller;

import com.epam.external.onlineShop.model.enums.UserRole;
import com.epam.external.onlineShop.manager.UserManager;
import com.epam.external.onlineShop.service.CategoryService;
import com.epam.external.onlineShop.service.ProductService;
import com.epam.external.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserManager userManager;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("currentUser", userManager.getUser());

        if (userManager.getUser().getUserRole().equals(UserRole.ADMIN)) {
            return "admin";
        }
        return "index";
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "login";
    }
}
