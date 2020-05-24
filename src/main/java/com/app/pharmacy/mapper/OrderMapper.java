package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.AddressDTO;
import com.app.pharmacy.dto.OrderDTO;
import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.model.Customer;
import com.app.pharmacy.model.Order;
import com.app.pharmacy.model.ProductOrder;
import com.app.pharmacy.repository.CustomerRepository;
import com.app.pharmacy.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chris Tzelis
 */
@Mapper(uses = {CustomerMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class OrderMapper {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Mappings({
        @Mapping(source = "customer.customerInfo", target = "customerInfo")
        ,
        @Mapping(source = "customer.personId", target = "customerId")
        ,
        @Mapping(source = "addressInfo", target = "addressInfoDto")
    })
    public abstract OrderDTO entityToDTO(Order entity);

    @Mappings({
        @Mapping(source = "customerId", target = "customer")
        ,
        @Mapping(source = "productDTOList", target = "productOrderList")
        ,
        @Mapping(source = "addressInfoDto", target = "addressInfo")
    })
    public abstract Order dtoToEntity(OrderDTO dto);

    public abstract List<OrderDTO> entityToDTOList(List<Order> list);

    public abstract List<Order> dtoToEntityList(List<OrderDTO> dtoList);

    public String getAddressInfo(AddressDTO addressDto) {
        if (addressDto != null) {
            try {
                return objectMapper.writeValueAsString(addressDto);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AddressDTO getAddressInfo(String addressInfo) {
        if (addressInfo != null) {
            try {
                return objectMapper.readValue(addressInfo, AddressDTO.class);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public Customer getCustomer(Integer customerId) {
        Optional<Customer> result = customerRepository.findById(customerId);
        return result.isPresent() ? result.get() : null;
    }

    public List<ProductOrder> getProductOrderList(List<ProductDTO> products) {
        List<ProductOrder> list = new ArrayList<>();
        if (products != null) {
            for (ProductDTO product : products) {
                ProductOrder productOrder = new ProductOrder();
                productOrder.setProduct(productRepository.findById(product.getProductId()).get());
                productOrder.setQuantity(product.getQuantity());
                list.add(productOrder);
            }
        }
        return list;
    }

    @AfterMapping
    public void setOrder(@MappingTarget Order order) {
        for (ProductOrder productOrder : order.getProductOrderList()) {
            productOrder.setOrder(order);
        }
    }

}
