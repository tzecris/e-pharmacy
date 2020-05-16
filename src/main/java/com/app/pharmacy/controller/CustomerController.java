package com.app.pharmacy.controller;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.CustomerService;
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
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity findAll(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, @RequestParam(name = "sort", defaultValue = "personId") String sort) {

        return ResponseEntity.ok(customerService.findAllPagination(page, size, sort));
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDTO c) {
        customerService.save(c);
        return ResponseEntity.ok(new ResponseMessage("Customer created succesfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Customer deleted successfully!"));
    }

    @PostMapping("/unique")
    public ResponseEntity uniqueEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(customerService.uniqueEmail(email));
    }
}
