package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.AddressDTO;
import com.app.pharmacy.model.Address;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper extends GenericMapper<AddressDTO, Address> {

}
