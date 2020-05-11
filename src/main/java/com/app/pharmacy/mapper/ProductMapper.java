
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.model.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
    
    ProductDTO entityToDTO(Product address);
    
     Product dtoToEntity(ProductDTO addressDTO);
    
}
