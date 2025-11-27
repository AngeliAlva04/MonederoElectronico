package com.stcm.app_web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/account")
    public String account(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "account";
    }

    @GetMapping("/history")
    public String history(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "history";
    }

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/reload")
    public String reload(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "reload";
    }

    @GetMapping("/settings")
    public String settings(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "settings";
    }
}
