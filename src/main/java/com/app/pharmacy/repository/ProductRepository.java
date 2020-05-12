
package com.app.pharmacy.repository;

import com.app.pharmacy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
    
    
}
