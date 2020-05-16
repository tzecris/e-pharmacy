package com.app.pharmacy.repository;

import com.app.pharmacy.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    public List<Product> findAll();

    public Page<Product> findAll(Pageable pageable);

}
