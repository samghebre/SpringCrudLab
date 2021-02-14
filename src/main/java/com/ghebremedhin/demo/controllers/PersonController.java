package com.ghebremedhin.demo.controllers;

import com.ghebremedhin.demo.model.Person;
import com.ghebremedhin.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(personService.getAllPerson());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person>getPersonById(@PathVariable long id){
        return ResponseEntity.ok().body(this.personService.getPersonById(id));
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return ResponseEntity.ok().body(this.personService.createPerson(person));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person person){
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updatePerson(person));
    }

    @DeleteMapping("/persons/{id}")
    public HttpStatus deletePerson(@PathVariable long id){
        this.personService.deletePerson(id);
        return HttpStatus.OK;
    }
}
