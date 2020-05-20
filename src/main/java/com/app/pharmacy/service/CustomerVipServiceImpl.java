package com.app.pharmacy.service;

import com.app.pharmacy.dto.CustomerVipDTO;
import com.app.pharmacy.mapper.CustomerVipMapper;
import com.app.pharmacy.model.Vip;
import com.app.pharmacy.repository.CustomerVipRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerVipServiceImpl implements CustomerVipService {

    @Autowired
    CustomerVipRepository customerVipRepo;

    @Autowired
    CustomerVipMapper customerVipMapper;


    @Override
    public List<CustomerVipDTO> findAll() {
        return customerVipMapper.entityToDTOList(customerVipRepo.findAll());
    }

    @Override
    @Transactional
    public void save(CustomerVipDTO dto) {
        customerVipRepo.save(customerVipMapper.dtoToEntity(dto));
    }

    @Override
    public CustomerVipDTO findById(Integer id) {
        Optional<Vip> result = customerVipRepo.findById(id);
        return result.isPresent() ? customerVipMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        customerVipRepo.deleteById(id);
    }

}
