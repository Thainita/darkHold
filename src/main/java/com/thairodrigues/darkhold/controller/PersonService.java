package com.thairodrigues.darkhold.controller;

import com.thairodrigues.darkhold.entity.Person;
import com.thairodrigues.darkhold.repository.IPersonRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class PersonService {

    @Autowired
    private IPersonRepository personRepository;

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(person);
    }
    @GetMapping("/person/list")
    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

}
