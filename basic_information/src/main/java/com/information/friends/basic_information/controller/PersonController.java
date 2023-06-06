package com.information.friends.basic_information.controller;

import com.information.friends.basic_information.entity.PersonEntity;
import com.information.friends.basic_information.response.PersonResponse;
import com.information.friends.basic_information.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping()
    public String welcomeGreet(){
        return "<center><h1>Welcome To Friends Service</h1></center>";
    }
    @GetMapping("/persons")
    public ResponseEntity<List<PersonResponse>> getAllThePersons(){
        return personService.getAllThePersons();
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable("id") int id){
        return personService.getPersonById(id);
    }
    @PostMapping("/manager")
    public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonEntity personEntity){
        return personService.addPerson(personEntity);
    }
    @PutMapping("/manager")
    public ResponseEntity<PersonResponse> update(@RequestBody PersonEntity personEntity){
        return personService.update(personEntity);
    }
    @DeleteMapping("/admin/{id}")
    public void deleteById(@PathVariable int id){
        personService.deleteById(id);
    }
}
