
package com.app.pharmacy.repository;

import com.app.pharmacy.model.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("select r from Review r where r.product.productId = :productId")
    List<Review> findByProductId(@Param("productId") Integer productId);
    
}
