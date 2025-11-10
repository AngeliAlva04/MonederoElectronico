package com.stcm.app_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stcm.app_web.entity.Persona;
import com.stcm.app_web.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/new")
    public String showCreatePersonForm() {
        return "personForm";
    }

    @PostMapping("/new")
    public String addPerson(@RequestParam(value = "nombres", required = false) String nombre,
            @RequestParam(value = "apellidos", required = false) String apellidos,
            @RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
            @RequestParam(value = "CURP", required = false) String curp,
            RedirectAttributes redirectAttributes) {

        System.out.println("POST /person/new RECIBIDO!");
        System.out.println("Parámetros recibidos:");
        System.out.println("  - nombres: " + nombre);
        System.out.println("  - apellidos: " + apellidos);
        System.out.println("  - fechaNacimiento: " + fechaNacimiento);
        System.out.println("  - CURP: " + curp);

        // Validar que todos los campos estén presentes
        if (nombre == null || apellidos == null || fechaNacimiento == null || curp == null) {
            System.out.println("Faltan parámetros requeridos");
            redirectAttributes.addFlashAttribute("error", "Todos los campos son requeridos");
            return "redirect:/person/new";
        }

        try {
            // Convertir String a LocalDate
            java.time.LocalDate fecha = java.time.LocalDate.parse(fechaNacimiento);

            // Crear y guardar persona
            Persona persona = new Persona(nombre, apellidos, fecha, curp);
            personService.createPersonWithCustomQuery(persona);

            System.out.println("Persona registrada correctamente");
            redirectAttributes.addFlashAttribute("success", "Persona registrada exitosamente");

        } catch (Exception e) {
            System.out.println("Error al registrar persona: " + e.getMessage());
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error al registrar: " + e.getMessage());
            return "redirect:/person/new";
        }

        return "redirect:/home";
    }
}