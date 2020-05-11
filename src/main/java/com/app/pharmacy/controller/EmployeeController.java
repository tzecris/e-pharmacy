package com.app.pharmacy.controller;

import com.app.pharmacy.dto.EmployeeDTO;
import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chris Tzelis
 */
@Controller
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity findAll() {

        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO e) {
        employeeService.save(e);
        return ResponseEntity.ok(new ResponseMessage("Employee created succesfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Employee deleted successfully!"));
    }

}
