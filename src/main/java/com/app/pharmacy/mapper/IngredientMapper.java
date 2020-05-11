package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.IngredientDTO;
import com.app.pharmacy.model.Ingredient;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IngredientMapper {
    
    IngredientDTO entityToDTO(Ingredient Ingredient);
    
    Ingredient dtoToEntity(IngredientDTO IngredientDTO);
    
    List<IngredientDTO> entityToDTOList(List<Ingredient> list);

    List<Ingredient> dtoToEntityList(List<IngredientDTO> list);
    
}
