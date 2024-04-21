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

import java.util.ArrayList;
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
    public String searchHotels(
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "name", required = false) String name,
            Model model
    ) {
        List<Hotel> hotels;

        if (location != null && name != null) {
            // Если заданы оба параметра, ищем по обоим
            hotels = hotelService.findHotelsByLocationAndName(location, name);
        } else if (location != null) {
            // Если задан только location, ищем по нему
            hotels = hotelService.findHotelsByLocation(location);
        } else if (name != null) {
            // Если задано только название, ищем по нему
            hotels = hotelService.findHotelsByName(name);
        } else {
            hotels = new ArrayList<>(); // Если не заданы параметры, возвращаем пустой список
        }

        model.addAttribute("hotels", hotels);
        return "hotel_search_results";
    }



}
