
package com.app.pharmacy.service;

import com.app.pharmacy.dto.PersonDTO;


public interface PersonService extends GenericService<PersonDTO> {
    
    public boolean uniqueEmail(String email);
}
