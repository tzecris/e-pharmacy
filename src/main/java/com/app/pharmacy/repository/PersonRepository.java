
package com.app.pharmacy.repository;

import com.app.pharmacy.model.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    
    public Optional<Person> findByEmail(String email);
    
}
