
package com.app.pharmacy.repository;

import com.app.pharmacy.model.RatingsPerCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingPerCustomerRepository extends JpaRepository<RatingsPerCustomer, Integer>{
    
}
