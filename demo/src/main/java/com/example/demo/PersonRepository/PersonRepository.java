package com.example.demo.PersonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Person.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{
    Person findByNombre(String nombre);

}


