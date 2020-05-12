package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.PersonDTO;
import com.app.pharmacy.model.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {AddressMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonMapper extends GenericMapper<PersonDTO, Person>{

    

}
