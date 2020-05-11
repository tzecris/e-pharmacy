
package com.app.pharmacy.service;

import com.app.pharmacy.dto.OrderVipDTO;
import com.app.pharmacy.mapper.OrderVipMapper;
import com.app.pharmacy.model.OrderVip;
import com.app.pharmacy.repository.OrderVipRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class OrderVipServiceImpl implements OrderVipService{
    
    @Autowired
    OrderVipRepository orderVipRepo;

    @Autowired
    OrderVipMapper orderVipMapper;
    
    @Override
    public List<OrderVipDTO> findAll() {
        return orderVipMapper.entityToDTOList(orderVipRepo.findAll());
    }

    @Override
    @Transactional
    public void save(OrderVipDTO dto) {
        orderVipRepo.save(orderVipMapper.dtoToEntity(dto));
    }

    @Override
    public OrderVipDTO findById(Integer id) {
        Optional<OrderVip> result = orderVipRepo.findById(id);
        return result.isPresent() ? orderVipMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        orderVipRepo.deleteById(id);
    }
}
