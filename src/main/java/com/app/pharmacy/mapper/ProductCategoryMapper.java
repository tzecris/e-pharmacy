
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.ProductCategoryDTO;
import com.app.pharmacy.model.ProductCategory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCategoryMapper extends GenericMapper<ProductCategoryDTO, ProductCategory>{
    
}
