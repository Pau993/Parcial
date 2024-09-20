package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Person.Person;
import com.example.demo.PersonService.PersonService;

import lombok.RequiredArgsConstructor;

import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private PersonService productService;
    
    private final PersonService personService;

    @PostMapping
    public void createPerson(@RequestBody Person person){
        personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getProductById(@PathVariable Long id) {
        Person product = personService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Person> updateStock(@PathVariable Long id, @RequestBody int newStock) {
        Person updatedProduct = productService.updateStock(id, newStock);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }
    
}
