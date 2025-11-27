package com.stcm.app_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    // Este GetMapping redirige a la página de login cuando se accede a la raíz del dominio
    // Es mala práctica debes de poner el login.html como index y sacarlo de la carpeta de donde estan las vistas privadas
    @GetMapping("/")
    public String home() { 
        return "forward:/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión correctamente");
        }
        return "login";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
}