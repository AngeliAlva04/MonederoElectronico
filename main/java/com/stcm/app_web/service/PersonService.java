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
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Crea/Registra a una nueva persona
    public void createPerson(Persona persona) {
        personRepository.save(persona);
    }
}