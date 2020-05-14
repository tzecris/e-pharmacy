package com.app.pharmacy.service;

import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.model.Review;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.pharmacy.mapper.ReviewMapper;
import com.app.pharmacy.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository ratingPerCustomerRepo;

    @Autowired
    ReviewMapper ratingPerCustomerMapper;

    @Override
    public List<ReviewDTO> findAll() {
                return ratingPerCustomerMapper.entityToDTOList(ratingPerCustomerRepo.findAll());

    }

    @Override
    public void save(ReviewDTO dto) {
        ratingPerCustomerRepo.save(ratingPerCustomerMapper.dtoToEntity(dto));
    }

    @Override
    public ReviewDTO findById(Integer id) {
        Optional<Review> result = ratingPerCustomerRepo.findById(id);
        return result.isPresent() ? ratingPerCustomerMapper.entityToDTO(result.get()) : null;
    }

    @Override
    public void deleteById(Integer id) {
        ratingPerCustomerRepo.deleteById(id);
    }

}
