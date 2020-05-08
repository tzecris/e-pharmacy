package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.OrderDTO;
import com.app.pharmacy.model.Customer;
import com.app.pharmacy.model.Order;
import com.app.pharmacy.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chris Tzelis
 */
@Mapper(uses = {CustomerMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class OrderMapper {

    @Autowired
    CustomerRepository customerRepository;

    @Mapping(source = "customer.personId", target = "customerId")
    abstract OrderDTO entityToDTO(Order entity);

    @Mapping(source = "customerId", target = "customer")
    abstract Order dtoToEntity(OrderDTO dto);

    abstract List<OrderDTO> entityToDTOList(List<Order> list);

    abstract List<Order> dtoToEntityList(List<OrderDTO> dtoList);

    public Customer getCustomer(Integer customerId) {
        Optional<Customer> result = customerRepository.findById(customerId);
        return result.isPresent() ? result.get() : null;
    }
}
