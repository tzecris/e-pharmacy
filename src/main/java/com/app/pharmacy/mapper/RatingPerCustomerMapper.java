
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.RatingPerCustomerDTO;
import com.app.pharmacy.model.RatingsPerCustomer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductMapper.class,CustomerMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RatingPerCustomerMapper extends GenericMapper<RatingPerCustomerDTO, RatingsPerCustomer>{
    
}
