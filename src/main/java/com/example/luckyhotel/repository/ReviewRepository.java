package com.example.luckyhotel.repository;

import com.example.luckyhotel.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    // Запрос для поиска отзывов по отелю
    List<Review> findByHotelId(Long hotelId);
}
