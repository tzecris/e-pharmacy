
package com.app.pharmacy.service;


import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.mapper.ProductMapper;
import com.app.pharmacy.model.Product;
import com.app.pharmacy.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.entityToDTOList(productRepo.findAll());
    }

    @Override
    @Transactional
    public void save(ProductDTO dto) {
        productRepo.save(productMapper.dtoToEntity(dto));
    }

    @Override
    public ProductDTO findById(Integer id) {
        Optional<Product> result = productRepo.findById(id);
        return result.isPresent() ? productMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }


}
