
package com.app.pharmacy.repository;

import com.app.pharmacy.model.ProductCategory;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Integer> {

    public List<ProductCategory> findAll();

    public Page<ProductCategory> findAll(Pageable pageable);
    
}
