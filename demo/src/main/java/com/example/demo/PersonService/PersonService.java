package com.example.demo.PersonService;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Person.Person;
import com.example.demo.PersonRepository.PersonRepository;

import lombok.RequiredArgsConstructor;
import java.util.*;


@Service
@RequiredArgsConstructor
public class PersonService {
    
    @Autowired
    private PersonRepository personRep;
    public void createPerson(Person person){
        personRep.save(person);
    }


    public void modificarStock(String nombre, int cantidad) {
        Person person = personRep.findByNombre(nombre);
        if (person != null) {
            person.setCantidad(person.getCantidad() + cantidad);
            personRep.save(person);
            notificarAgentes(person);
        }
    }

    private void notificarAgentes(Person person) {
        agenteUnidades(person);
        agenteAlerta(person);
    }

    private void agenteUnidades(Person person) {
        System.out.println("Unidades disponibles de " + person.getNombre() + ": " + person.getCantidad());
    }

    private void agenteAlerta(Person person) {
        if (person.getCantidad() < 5) {
            System.out.println("ALERTA: Solo quedan " + person.getCantidad() + " unidades de " + person.getNombre() + ".");
        }
    }

    public Person getProductById(Long id) {
        return personRep.findById(id).orElse(null);
    }

    public Person updateStock(Long id, int newStock) {
        Person person = personRep.findById(id).orElse(null);
        if (person != null) {
            person.setStock(newStock);
            personRep.save(person);
            // Aquí llamarías a la función de notificación
            notifyAgents(person);
        }
        return person;
    }

    private void notifyAgents(Person person) {
        System.out.println("Notificación: El stock del producto '" + person.getNombre() + "' ha cambiado a " + person.getCantidad());
    }

}

