
package com.app.pharmacy.controller;

import com.app.pharmacy.dto.RatingPerCustomerDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.RatingPerCustomerService;
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
@RequestMapping("api/ratings")
public class RatingPerCustomerController {
    @Autowired
    RatingPerCustomerService ratingPerCustomerService;
    
    @GetMapping
    public ResponseEntity findAllProducts(){
        return ResponseEntity.ok(ratingPerCustomerService.findAll());
    }
    
    @PostMapping
    public ResponseEntity createProduct(@RequestBody RatingPerCustomerDTO p){
        ratingPerCustomerService.save(p);
        return ResponseEntity.ok(new ResponseMessage("rating created succesfully"));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(ratingPerCustomerService.findById(id));
    } 
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        ratingPerCustomerService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Product deleted successfully!"));
    }
}
