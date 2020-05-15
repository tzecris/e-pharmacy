package com.app.pharmacy.service;

import com.app.pharmacy.dto.SecurityUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Chris Tzelis
 */
public interface AuthenticationService {


    public void login(SecurityUser securityUser) throws UsernameNotFoundException;

}
