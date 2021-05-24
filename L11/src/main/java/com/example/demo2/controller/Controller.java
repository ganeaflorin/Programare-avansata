package com.example.demo2.controller;

import com.example.demo2.PersonEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello!";
    }

    private List<PersonEntity> persons = new ArrayList<>();

    public Controller() {
        PersonEntity person = new PersonEntity();
        person.setName("Florin");
        persons.add(person);
    }

    @PostMapping("/insert/{name}")
    public PersonEntity createPerson(@PathVariable String name) {
        PersonEntity person = new PersonEntity();
        int id = persons.size();
        person.setName(name);
        person.setId(id);
        persons.add(person);
        return person;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@RequestParam String name, @PathVariable(value = "id") int id) {
        boolean wasFound = false;
        for (PersonEntity person : persons)
            if (person.getId() == id) {
                person.setName(name);
                wasFound = true;
            }
        if (wasFound) return new ResponseEntity<>("Updated successful!", HttpStatus.OK);
        return new ResponseEntity<>("Id not found!", HttpStatus.GONE);
    }

    @RequestMapping("/getall")
    public List<PersonEntity> getAll() {
        return persons;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        boolean wasFound = false;
        for (PersonEntity person : persons) {
            if (person.getId() == id) {
                persons.remove(person);
                wasFound = true;
            }
        }
        if (wasFound) return new ResponseEntity<>("Person was deleted", HttpStatus.OK);
        return new ResponseEntity<>("Person was not found.", HttpStatus.GONE);
    }


}
