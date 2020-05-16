package com.app.pharmacy.service;

import com.app.pharmacy.dto.IngredientDTO;
import com.app.pharmacy.dto.SearchResults;


public interface IngredientService extends GenericService<IngredientDTO> {

    public SearchResults findAllPegination(int page, int size, String sort);
    
}
