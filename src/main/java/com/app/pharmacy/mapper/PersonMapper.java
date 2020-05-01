package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.PersonDTO;
import com.app.pharmacy.model.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 *
 * @author Admin
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonMapper {

    PersonDTO entityToDTO(Person person);

    Person dtoToEntity(PersonDTO personDTO);

}
