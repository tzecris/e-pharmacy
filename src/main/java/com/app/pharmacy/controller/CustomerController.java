/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.pharmacy.controller;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.mapper.CustomerMapper;
import com.app.pharmacy.model.Customer;
import com.app.pharmacy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    
    @Autowired
    CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer c) {
        return ResponseEntity.ok(customerService.save(c));
    }

}
