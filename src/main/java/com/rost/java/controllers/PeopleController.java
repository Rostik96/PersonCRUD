package com.rost.java.controllers;

import com.rost.java.PersonDAO;
import com.rost.java.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public void index() {
        personDAO.index().forEach(System.out::println);
    }

    @GetMapping("/{id}")
    public void readPersonById(@PathVariable("id") int id) {
        Person resultPerson = personDAO.index().stream()
                .filter(person -> person.getId() == id)
                        .findAny()
                                .orElse(null);
        System.out.println(resultPerson);
    }
}