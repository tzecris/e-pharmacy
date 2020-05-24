package com.app.pharmacy.service;

import com.app.pharmacy.dto.OrderDTO;
import java.util.List;

public interface OrderService extends GenericService<OrderDTO> {

    public List<OrderDTO> findByCustomerEmail(String email);

}
