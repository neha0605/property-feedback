package com.property.feedback.service.impl;

import com.property.feedback.repository.ReviewRepo;
import com.property.feedback.service.ReviewService;
import com.property.feedback.repository.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nehaojha on 02/11/16.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public void addReview(Review review) {
        reviewRepo.save(review);
    }
}
