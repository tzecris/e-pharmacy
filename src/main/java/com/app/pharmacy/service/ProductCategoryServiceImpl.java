
package com.app.pharmacy.service;

import com.app.pharmacy.dto.ProductCategoryDTO;
import com.app.pharmacy.dto.SearchResults;
import com.app.pharmacy.mapper.ProductCategoryMapper;
import com.app.pharmacy.model.ProductCategory;
import com.app.pharmacy.repository.ProductCategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    
    @Autowired
    ProductCategoryRepository productCategoryRepo;

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    

    @Override
    public List<ProductCategoryDTO> findAll() {
        return productCategoryMapper.entityToDTOList(productCategoryRepo.findAll());
    }
    
    @Override
    @Transactional
    public void save(ProductCategoryDTO dto) {
        productCategoryRepo.save(productCategoryMapper.dtoToEntity(dto));
    }

    @Override
    public ProductCategoryDTO findById(Integer id) {
        Optional<ProductCategory> result = productCategoryRepo.findById(id);
        return result.isPresent() ? productCategoryMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productCategoryRepo.deleteById(id);
    }
    
}
