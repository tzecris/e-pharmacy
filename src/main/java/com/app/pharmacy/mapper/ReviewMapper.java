package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.model.Customer;
import com.app.pharmacy.model.Review;
import com.app.pharmacy.repository.CustomerRepository;
import java.util.Optional;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ReviewMapper implements GenericMapper<ReviewDTO, Review> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Mapping(source = "customer.email", target = "username")
    public abstract ReviewDTO entityToDTO(Review entity);

    @Override
    @Mapping(source = "username", target = "customer")
    public abstract Review dtoToEntity(ReviewDTO dto);

    public Customer getCustomer(String username) {
        Optional<Customer> result = customerRepository.findByEmail(username);
        return result.isPresent() ? result.get() : null;
    }

}
