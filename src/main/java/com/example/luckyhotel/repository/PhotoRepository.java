package com.example.luckyhotel.repository;

import com.example.luckyhotel.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PhotoRepository extends JpaRepository<Photo,Long> {
}
