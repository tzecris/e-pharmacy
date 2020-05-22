package com.app.pharmacy.controller;

import com.app.pharmacy.dto.OrderDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chris Tzelis
 */
@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderDTO c) {
        orderService.save(c);
        return ResponseEntity.ok(new ResponseMessage("Order created succesfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        orderService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Order deleted successfully!"));
    }
}
