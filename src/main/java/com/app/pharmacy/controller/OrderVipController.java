
package com.app.pharmacy.controller;

import com.app.pharmacy.dto.OrderVipDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.OrderVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ordervip")
public class OrderVipController {
    @Autowired
    OrderVipService orderVipService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(orderVipService.findAll());
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody OrderVipDTO c) {
        orderVipService.save(c);
        return ResponseEntity.ok(new ResponseMessage("OrderVip created succesfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(orderVipService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        orderVipService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("OrderVip deleted successfully!"));
    }

    
}
