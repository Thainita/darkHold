package com.thairodrigues.darkhold.controller;

import com.thairodrigues.darkhold.entity.Person;
import com.thairodrigues.darkhold.repository.IPersonRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private IPersonRepository personRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(person);
    }

    @GetMapping()
    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    @PostMapping()
    public Person createPerson(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Person> updateUser(
            @PathVariable(value = "id") Long personId, @Valid @RequestBody Person personDetails)
            throws ResourceNotFoundException {

        Person person =
                personRepository
                        .findById(personId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + personId));

        person.setEmail(personDetails.getEmail());
        person.setLastName(personDetails.getLastName());
        person.setFirstName(personDetails.getFirstName());
        //person.setUpdatedAt(new Date());
        final Person updatedUser = personRepository.save(person);
        return ResponseEntity.ok(updatedUser);
    }
}
