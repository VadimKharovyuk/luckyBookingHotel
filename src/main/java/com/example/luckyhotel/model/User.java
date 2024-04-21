package com.example.luckyhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "app_user") // Используйте альтернативное имя для таблицы, чтобы избежать конфликтов с зарезервированными словами
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Имя пользователя

    // Хешированный пароль (укажите длину и уточните алгоритм хеширования в конфигурации)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Booking> bookings; // Бронирования пользователя

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews; // Отзывы пользователя

    private String role; // Роль (например, 'USER' или 'ADMIN')
}

