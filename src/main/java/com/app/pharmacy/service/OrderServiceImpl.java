package com.app.pharmacy.service;

import com.app.pharmacy.dto.OrderDTO;
import com.app.pharmacy.mapper.OrderMapper;
import com.app.pharmacy.model.Order;
import com.app.pharmacy.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris Tzelis
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderDTO> findAll() {
        return orderMapper.entityToDTOList(orderRepo.findAll());
    }

    @Override
    public void save(OrderDTO dto) {
        orderRepo.save(orderMapper.dtoToEntity(dto));
    }

    @Override
    public OrderDTO findById(Integer id) {
        Optional<Order> result = orderRepo.findById(id);
        return result.isPresent() ? orderMapper.entityToDTO(result.get()) : null;
    }

    @Override
    public void deleteById(Integer id) {
        orderRepo.deleteById(id);
    }

    @Override
    public List<OrderDTO> findByCustomerEmail(String email) {
        return orderMapper.entityToDTOList(orderRepo.findByCustomerEmail(email));
    }

}
