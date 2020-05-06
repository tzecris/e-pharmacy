package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.model.Customer;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {PersonMapper.class, AddressMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {

    CustomerDTO entityToDTO(Customer customer);

    Customer dtoToEntity(CustomerDTO customerDTO);

    List<CustomerDTO> entityToDTOList(List<Customer> list);

    List<Customer> dtoToEntityList(List<CustomerDTO> list);

}
