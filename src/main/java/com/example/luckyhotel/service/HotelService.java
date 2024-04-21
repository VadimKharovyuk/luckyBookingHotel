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
    public List<Hotel> searchHotelsByName(String name) {
        return hotelRepository.findByNameContainingIgnoreCase(name);
    }



    public List<Hotel> findHotelsByLocation(String location) {
        return hotelRepository.findByLocation(location); // Возвращаем список отелей, найденных по 'location'
    }


    // Методы для поиска отелей по различным критериям (например, по локации)
}