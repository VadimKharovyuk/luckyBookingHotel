package com.example.luckyhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Тип комнаты (односпальная, двуспальная и др.)
    private BigDecimal price; // Цена за ночь

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
