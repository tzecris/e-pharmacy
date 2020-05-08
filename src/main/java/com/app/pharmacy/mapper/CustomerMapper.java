package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.model.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {PersonMapper.class, AddressMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper extends GenericMapper<CustomerDTO, Customer> {

}
