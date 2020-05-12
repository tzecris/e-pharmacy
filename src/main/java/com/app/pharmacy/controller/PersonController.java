
package com.app.pharmacy.controller;

import com.app.pharmacy.dto.PersonDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody PersonDTO p) {
        personService.save(p);
        return ResponseEntity.ok(new ResponseMessage("Person created succesfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPerson(@PathVariable Integer id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id) {
        personService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Person deleted successfully!"));
    }

    @PostMapping("/unique")
    public ResponseEntity uniqueEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(personService.uniqueEmail(email));
    }
    
}
