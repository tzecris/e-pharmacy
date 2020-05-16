package com.app.pharmacy.controller;

import com.app.pharmacy.dto.IngredientDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.IngredientService;
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
@RequestMapping("api/ingredients")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public ResponseEntity findByFilter(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sort", defaultValue = "name") String sort) {
        return ResponseEntity.ok(ingredientService.findAllPegination(page, size, sort));
    }

    @PostMapping
    public ResponseEntity createIngredient(@RequestBody IngredientDTO c) {
        ingredientService.save(c);
        return ResponseEntity.ok(new ResponseMessage("Ingredient created succesfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity getIngredient(@PathVariable Integer id) {
        return ResponseEntity.ok(ingredientService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Integer id) {
        ingredientService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Ingredient deleted successfully!"));
    }

    @PostMapping("unique")
    public ResponseEntity uniqueIngredient() {
        return ResponseEntity.ok("");
    }
}
