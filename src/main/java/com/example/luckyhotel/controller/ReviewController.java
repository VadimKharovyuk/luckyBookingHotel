package com.example.luckyhotel.controller;

import com.example.luckyhotel.model.Hotel;
import com.example.luckyhotel.model.Review;
import com.example.luckyhotel.model.User;
import com.example.luckyhotel.service.HotelService;
import com.example.luckyhotel.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final HotelService hotelService ;

    // Получить все отзывы по определенному отелю
    @GetMapping("/hotel/{hotelId}")
    public String getReviewsByHotel(@PathVariable Long hotelId, Model model) {
        List<Review> reviews = reviewService.getReviewsByHotel(hotelId);
        model.addAttribute("reviews", reviews); // Добавляем отзывы в модель
        return "hotel-reviews"; // Имя HTML-шаблона для отображения отзывов
    }
    // Обработчик GET-запроса для отображения формы добавления нового отзыва
    @GetMapping("/reviews/add")
    public String addReviewForm(
            @RequestParam(value = "userId", required = false) Long userId,
            Model model) {

        // Получить список всех отелей
        List<Hotel> hotels = hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);

        // Добавить в модель список отелей и ID пользователя
        model.addAttribute("userId", userId);

        return "add-review"; // Имя шаблона
    }



    // Метод для добавления нового отзыва
    @PostMapping("/add")
    public String addReview(
            @RequestParam("comment") String comment,
            @RequestParam("rating") int rating,
            @RequestParam("hotelId") Long hotelId,
            @RequestParam("userId") Long userId) {

        Review review = new Review();
        review.setComment(comment);
        review.setRating(rating);
        review.setHotel(new Hotel(hotelId));
        review.setUser(new User(userId));
        review.setDate(new Date());

        reviewService.saveReview(review);

        // Перенаправление на страницу с отзывами по отелю
        return "redirect:/reviews/hotel/" + hotelId;
    }
}