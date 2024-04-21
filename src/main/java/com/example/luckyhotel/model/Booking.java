package com.example.luckyhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room; // Забронированный номер

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Пользователь, который сделал бронирование

    private Date checkInDate; // Дата заезда
    private Date checkOutDate; // Дата выезда

    private int guestCount; // Количество гостей
}
