package com.app.pharmacy.controller;

import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.dto.ProductSearchFilters;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.ProductService;
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
@RequestMapping("api/products")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping
    public ResponseEntity findByFilter(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sort", defaultValue = "name") String sort) {
        return ResponseEntity.ok(productService.findAllPagination(page, size, sort));
    }
    
    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductDTO p) {
        productService.save(p);
        return ResponseEntity.ok(new ResponseMessage("Product created succesfully"));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Product deleted successfully!"));
    }
    
    @PostMapping("/search")
    public ResponseEntity searchByFilters(@RequestBody ProductSearchFilters searchFilters,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sort", defaultValue = "name") String sort,
            @RequestParam(name = "order", defaultValue = "ASC") String order) {
        return ResponseEntity.ok(productService.findByFilter(page, size, sort, order, searchFilters));
    }
    
}
