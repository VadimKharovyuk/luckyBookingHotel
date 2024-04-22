package com.example.luckyhotel.repository;

import com.example.luckyhotel.model.Photo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface PhotoRepository extends JpaRepository<Photo,Long> {
    List<Photo> findAllByHotelId(Long hotelId);


}
