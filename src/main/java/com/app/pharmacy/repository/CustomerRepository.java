package com.app.pharmacy.repository;

import com.app.pharmacy.model.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findByEmail(String email);

}
