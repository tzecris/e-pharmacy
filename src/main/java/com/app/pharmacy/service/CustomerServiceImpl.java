package com.app.pharmacy.service;

import com.app.pharmacy.model.Customer;
import com.app.pharmacy.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    @Transactional
    public Customer save(Customer entity) {
        return customerRepo.save(entity);
    }

    @Override
    public Customer findById(Integer id) {
        Optional<Customer> result = customerRepo.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    @Transactional
    public void delete(Customer entity) {
        customerRepo.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        customerRepo.deleteById(id);
    }

}
