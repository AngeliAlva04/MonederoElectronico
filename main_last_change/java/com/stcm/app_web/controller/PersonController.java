package com.stcm.app_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stcm.app_web.entity.Persona;
import com.stcm.app_web.entity.Usuario;
import com.stcm.app_web.service.PersonService;
import com.stcm.app_web.service.UserService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String showCreatePersonForm() {
        return "personForm";
    }

    @PostMapping("/new")
    public String addPerson(@RequestParam(value = "nombres", required = false) String nombre,
            @RequestParam(value = "apellidos", required = false) String apellidos,
            @RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
            @RequestParam(value = "CURP", required = false) String curp,
            @RequestParam(value = "usuario", required = false) String nombreUsuario,
            @RequestParam(value = "contrasena", required = false) String contrasena,
            @RequestParam(value = "confirmarContrasena", required = false) String confirmarContrasena,
            RedirectAttributes redirectAttributes) {

        System.out.println("POST /person/new RECIBIDO!");
        System.out.println("Parámetros recibidos:");
        System.out.println("  - nombres: " + nombre);
        System.out.println("  - apellidos: " + apellidos);
        System.out.println("  - fechaNacimiento: " + fechaNacimiento);
        System.out.println("  - CURP: " + curp);
        System.out.println("  - usuario: " + nombreUsuario);
        System.out.println("  - contrasena: " + contrasena);

        // Validaciones
        if (nombre == null || apellidos == null || fechaNacimiento == null || 
            curp == null || nombreUsuario == null || contrasena == null || confirmarContrasena == null) {
            System.out.println("Faltan parámetros requeridos");
            redirectAttributes.addFlashAttribute("error", "Todos los campos son requeridos");
            return "redirect:/person/new";
        }

        if (!contrasena.equals(confirmarContrasena)) {
            System.out.println("Las contraseñas no coinciden");
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
            return "redirect:/person/new";
        }

        if (userService.userExists(nombreUsuario)) {
            System.out.println("El usuario ya existe");
            redirectAttributes.addFlashAttribute("error", "El nombre de usuario ya está en uso");
            return "redirect:/person/new";
        }

        try {
            // Convertir String a LocalDate
            java.time.LocalDate fecha = java.time.LocalDate.parse(fechaNacimiento);

            // 1. Crear y guardar persona
            Persona persona = new Persona(nombre, apellidos, fecha, curp);
            personService.createPersonWithCustomQuery(persona);

            // 2. Crear y guardar usuario
            userService.createUser(nombreUsuario, contrasena);

            System.out.println("Persona y usuario registrados correctamente");
            redirectAttributes.addFlashAttribute("success", "Registro exitoso. Ahora puedes iniciar sesión");

        } catch (Exception e) {
            System.out.println("Error al registrar: " + e.getMessage());
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error al registrar: " + e.getMessage());
            return "redirect:/person/new";
        }

        return "redirect:/login?success=true";
    }
}