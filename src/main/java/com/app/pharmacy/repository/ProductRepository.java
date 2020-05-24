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

    public List<Product> findByProductCategoryListIn(List<Integer> c);

    public List<Product> findByPriceBetween(double min, double max);

    public List<Product> findByStockGreaterThan(int s);

    public List<Product> findByDiscountGreaterThan(double d);

    public List<Product> findByPrescripted(boolean p);

    public List<Product> findByName(String name);

}
