
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.model.Review;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductMapper.class,CustomerMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ReviewMapper extends GenericMapper<ReviewDTO, Review>{
    
}
