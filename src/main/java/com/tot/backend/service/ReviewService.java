package com.tot.backend.service;

import com.tot.backend.dto.ReviewDto;
import com.tot.backend.model.Review;
import com.tot.backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(ReviewDto reviewDto) {
        Review review = new Review();
        return reviewRepository.save(review);
    }
}
