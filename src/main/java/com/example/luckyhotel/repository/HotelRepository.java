package com.example.luckyhotel.repository;

import com.example.luckyhotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByNameContainingIgnoreCase(String name); // Поиск по названию, без учета регистра

    List<Hotel> findByLocation(String location); // Поиск по местоположению

    List<Hotel> findByLocationAndNameContainingIgnoreCase(String location, String name);

}


