package com.example.luckyhotel.service;

import com.example.luckyhotel.model.Review;
import com.example.luckyhotel.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    // Методы для управления отзывами (например, удаление отзыва)
}
