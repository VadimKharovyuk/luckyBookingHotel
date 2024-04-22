package com.example.luckyhotel.model;

import com.example.luckyhotel.model.Amenity;
import com.example.luckyhotel.model.Photo;
import com.example.luckyhotel.model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация ID
    private Long id;

    private String name; // Название отеля
    private String location; // Местоположение (город или страна)
    private String description; // Описание отеля

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos; // Список фотографий, связанных с отелем

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms; // Типы номеров в отеле

    @ManyToMany
    @JoinTable(
            name = "hotel_amenities",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Set<Amenity> amenities; // Удобства (Wi-Fi, бассейн и др.)

    public Hotel(Long hotelId) {
        this.id = hotelId; // Установка ID
    }
}
