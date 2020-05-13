package com.app.pharmacy.service;

import com.app.pharmacy.dto.RatingPerCustomerDTO;
import com.app.pharmacy.mapper.RatingPerCustomerMapper;
import com.app.pharmacy.model.RatingsPerCustomer;
import com.app.pharmacy.repository.RatingPerCustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingPerCustomerServiceImpl implements RatingPerCustomerService {

    @Autowired
    RatingPerCustomerRepository ratingPerCustomerRepo;

    @Autowired
    RatingPerCustomerMapper ratingPerCustomerMapper;

    @Override
    public List<RatingPerCustomerDTO> findAll() {
                return ratingPerCustomerMapper.entityToDTOList(ratingPerCustomerRepo.findAll());

    }

    @Override
    public void save(RatingPerCustomerDTO dto) {
        ratingPerCustomerRepo.save(ratingPerCustomerMapper.dtoToEntity(dto));
    }

    @Override
    public RatingPerCustomerDTO findById(Integer id) {
        Optional<RatingsPerCustomer> result = ratingPerCustomerRepo.findById(id);
        return result.isPresent() ? ratingPerCustomerMapper.entityToDTO(result.get()) : null;
    }

    @Override
    public void deleteById(Integer id) {
        ratingPerCustomerRepo.deleteById(id);
    }

}
