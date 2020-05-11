package com.app.pharmacy.repository;

import com.app.pharmacy.model.Customer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    public List<Customer> findByEmail(String email);

    public List<Customer> findAll();

    public Page<Customer> findAll(Pageable pageable);

}
