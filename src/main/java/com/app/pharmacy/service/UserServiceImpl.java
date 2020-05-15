package com.app.pharmacy.service;

import com.app.pharmacy.model.Person;
import com.app.pharmacy.repository.PersonRepository;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris Tzelis
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> result = personRepository.findByEmail(email);
        if (!result.isPresent()) {
            throw new UsernameNotFoundException("Invalid username");
        }
        Person myuser = result.get();
        User securityUser
                = new User(myuser.getEmail(), myuser.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_" + myuser.getRole().name())));
        return securityUser;
    }

}
