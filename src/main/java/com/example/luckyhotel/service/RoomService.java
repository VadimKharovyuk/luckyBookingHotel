package com.example.luckyhotel.service;

import com.example.luckyhotel.model.Room;
import com.example.luckyhotel.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;



    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    // Методы для поиска комнат по другим критериям
}