package com.example.luckyhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация идентификатора
    private Long id;

    private String url; // URL фотографии

    private String description; // Описание фотографии

    @ManyToOne
    @JoinColumn(name = "hotel_id") // Связь с таблицей Hotel
    private Hotel hotel;
}
