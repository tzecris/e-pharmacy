/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.model.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {PersonMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {

    CustomerDTO entityToDTO(Customer customer);

    Customer dtoToEntity(CustomerDTO customerDTO);

}
