package com.example.luckyhotel.service;

import com.example.luckyhotel.model.Hotel;
import com.example.luckyhotel.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;


    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }


    public List<Hotel> findHotelsByLocation(String location) {
        return hotelRepository.findByLocation(location); // Возвращаем список отелей, найденных по 'location'
    }

    public List<Hotel> findHotelsByLocationAndName(String location, String name) {
        // Ищет отели по локации и названию
        return hotelRepository.findByLocationAndNameContainingIgnoreCase(location, name);
    }

    public List<Hotel> findHotelsByName(String name) {
        // Ищет отели только по названию
        return hotelRepository.findByNameContainingIgnoreCase(name);
    }


    // Методы для поиска отелей по различным критериям (например, по локации)
}