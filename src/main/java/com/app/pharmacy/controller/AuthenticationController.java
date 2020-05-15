package com.app.pharmacy.controller;

import com.app.pharmacy.dto.ResponseMessage;
import com.app.pharmacy.dto.SecurityUser;
import com.app.pharmacy.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chris Tzelis
 */
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecurityUser securityUser) {
        try {
            authService.login(securityUser);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage(e.getMessage()));
        }
        return ResponseEntity.ok(securityUser);
    }

}
