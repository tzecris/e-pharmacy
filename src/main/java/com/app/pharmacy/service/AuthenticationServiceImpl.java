package com.app.pharmacy.service;

import com.app.pharmacy.dto.SecurityUser;
import com.app.pharmacy.model.Person;
import com.app.pharmacy.repository.PersonRepository;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris Tzelis
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void login(SecurityUser securityUser) {
        Optional<Person> result = personRepository.findByEmail(securityUser.getUsername());
        if (!result.isPresent()) {
            throw new UsernameNotFoundException("Invalid username");
        }
        securityUser.setRole(result.get().getRole());
    }

}
