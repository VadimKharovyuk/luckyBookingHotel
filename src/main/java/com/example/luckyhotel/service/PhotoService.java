package com.example.luckyhotel.service;

import com.example.luckyhotel.model.Photo;
import com.example.luckyhotel.repository.PhotoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    // Найти фотографии по ID отеля
    public List<Photo> findPhotosByHotel(Long hotelId) {
        return photoRepository.findAllByHotelId(hotelId);
    }

    // Удалить фотографию по ID
    public void deletePhoto(Long photoId) {
        photoRepository.deleteById(photoId);
    }


    public void savePhoto(Photo photo) {
        photoRepository.save(photo);
    }
}
