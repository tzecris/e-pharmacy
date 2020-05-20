/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.pharmacy.controller;

import com.app.pharmacy.dto.ProductCategoryDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api/productcategories")
public class ProductCategoryController {
    
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity findAll() {

        return ResponseEntity.ok(productCategoryService.findAll());
    }
    
    @PostMapping
    public ResponseEntity createProductCategory(@RequestBody ProductCategoryDTO p) {
        productCategoryService.save(p);
        return ResponseEntity.ok(new ResponseMessage("Category created succesfully!"));
  }
    
    @GetMapping("/{id}")
    public ResponseEntity getProductCategory(@PathVariable Integer id) {
        return ResponseEntity.ok(productCategoryService.findById(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductCategory(@PathVariable Integer id) {
        productCategoryService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Category deleted successfully!"));
    }
    
    

}


    
