package com.stcm.app_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stcm.app_web.entity.Persona;
import com.stcm.app_web.repository.PersonRepository;


@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //Usando el query personalizado
    public void createPersonWithCustomQuery(Persona persona) {
        try {
            personRepository.savePersona(
                persona.getNombre(),
                persona.getApellidos(), 
                persona.getFechaNacimiento(),
                persona.getCurp()
            );
            System.out.println("Persona registrada con Query");
        } catch (Exception e) {
            System.out.println("Error en query: " + e.getMessage());
            throw e;
        }
    }
}