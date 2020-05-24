
package com.app.pharmacy.service;

import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.model.Review;
import java.util.List;


public interface ReviewService extends GenericService<ReviewDTO>{
    public List<ReviewDTO> findByProduct(Integer id);
}
