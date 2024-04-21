package com.example.luckyhotel.controller;

import com.example.luckyhotel.model.Hotel;
import com.example.luckyhotel.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;



    @GetMapping("/hotels")
    public String getHotels(Model model) {
        List<Hotel> hotels = hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }
    @GetMapping("/hotels/new")
    public String getAddHotelForm() {
        // Возвращает имя шаблона, который содержит форму для добавления отеля
        return "add-hotel"; // Имя HTML-шаблона, который вы создали для добавления отеля
    }

    @GetMapping("/hotels/{id}")
    public String getHotel(@PathVariable Long id, Model model) {
        Hotel hotel = hotelService.findHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotel-detail";
    }

    @PostMapping("/hotels")
    public String createHotel(Hotel hotel) {
        hotelService.createHotel(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/hotels/search")
    public String searchHotels(@RequestParam(name = "location") String location, Model model) {
        List<Hotel> hotels = hotelService.findHotelsByLocation(location);
        model.addAttribute("hotels", hotels);
        return "hotel_search_results";
    }


}
