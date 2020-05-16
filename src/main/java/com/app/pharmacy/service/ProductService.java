package com.app.pharmacy.service;

import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.dto.SearchResults;




public interface ProductService extends GenericService<ProductDTO> {

    public SearchResults findAllPegination(int page, int size, String sort);
    
    
    
}
