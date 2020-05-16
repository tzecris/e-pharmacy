package com.app.pharmacy.repository;

import com.app.pharmacy.model.Ingredient;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Integer> {

    public List<Ingredient> findAll();

    public Page<Ingredient> findAll(Pageable pageable);

}
