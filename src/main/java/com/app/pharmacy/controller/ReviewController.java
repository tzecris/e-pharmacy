
package com.app.pharmacy.controller;

import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pharmacy.service.ReviewService;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    
    @GetMapping
    public ResponseEntity findAllReviews() {
        return ResponseEntity.ok(reviewService.findAll());
    }
    
    @PostMapping
    public ResponseEntity createReview(@RequestBody ReviewDTO p) {
        reviewService.save(p);
        return ResponseEntity.ok(new ResponseMessage("Review created succesfully"));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getReview(@PathVariable Integer id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getReviewByProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(reviewService.findByProduct(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReview(@PathVariable Integer id) {
        reviewService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("Review deleted successfully!"));
    }
}
