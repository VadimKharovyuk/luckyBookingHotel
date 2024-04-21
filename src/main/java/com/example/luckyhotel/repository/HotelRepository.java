package com.example.luckyhotel.repository;

import com.example.luckyhotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByNameContainingIgnoreCase(String name);

    List<Hotel> findByLocation(String location);

}
