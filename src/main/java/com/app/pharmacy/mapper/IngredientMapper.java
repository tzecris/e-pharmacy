package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.IngredientDTO;
import com.app.pharmacy.model.Ingredient;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IngredientMapper extends GenericMapper<IngredientDTO, Ingredient> {

}
