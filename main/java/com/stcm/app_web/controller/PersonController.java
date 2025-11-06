package com.stcm.app_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.stcm.app_web.entity.Persona;
import com.stcm.app_web.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public String createPerson(@RequestParam Persona persona, Model model) {
        personService.createPerson(persona);
        model.addAttribute("message", "Persona creada exitosamente");
        return "personCreated";
    }
}