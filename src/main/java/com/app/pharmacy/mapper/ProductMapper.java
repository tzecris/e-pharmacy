
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.model.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductCategoryMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper extends GenericMapper<ProductDTO, Product> {
    
    
}
