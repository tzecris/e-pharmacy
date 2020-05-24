package com.app.pharmacy.service;

import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.dto.ProductSearchFilters;
import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.dto.SearchResults;

public interface ProductService extends GenericService<ProductDTO> {

    public SearchResults findAllPagination(int page, int size, String sort);

    public SearchResults findByFilter(int page, int size, String sort, String order, ProductSearchFilters psf);

    public void addReview(ReviewDTO dto, Integer id);

}
