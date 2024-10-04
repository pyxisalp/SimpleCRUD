package com.example.simpleCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 홈
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("nickname","User");
        return "home";
    }

}

