package com.example.luckyhotel.controller;

import com.example.luckyhotel.model.Photo;
import com.example.luckyhotel.model.Hotel;
import com.example.luckyhotel.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/photos") // Базовый путь для всех маршрутов в этом контроллере
@AllArgsConstructor // Конструктор со всеми аргументами, чтобы внедрить сервис
public class PhotoController {

    private final PhotoService photoService; // Сервис для работы с фотографиями

    // Метод для получения всех фотографий для определенного отеля
    @GetMapping("/hotel/{hotelId}")
    public String getPhotosByHotel(@PathVariable Long hotelId, Model model) {
        List<Photo> photos = photoService.findPhotosByHotel(hotelId); // Найти все фотографии по ID отеля
        model.addAttribute("photos", photos); // Добавить фотографии в модель для отображения в шаблоне
        return "photos"; // Имя шаблона для отображения
    }

    // Метод для отображения формы добавления фотографии
    @GetMapping("/add")
    public String addPhotoForm() {
        return "add-photo"; // Название шаблона HTML для формы добавления
    }

    @PostMapping("/add")
    public String addPhoto(
            @RequestParam("file") MultipartFile file,
            @RequestParam("hotelId") Long hotelId,
            @RequestParam("description") String description
    ) {
        if (file.isEmpty()) {
            // Если файл не загружен, возвращаем ошибку
            return "redirect:/photos/add?error=File+not+selected";
        }

        // Определяем путь к файлу
        String filePath = "static/photos/" + file.getOriginalFilename();
        File dest = new File(filePath);

        try {
            // Проверка, существует ли директория "static/photos", и создание при необходимости
            File directory = dest.getParentFile();
            if (!directory.exists()) {
                directory.mkdirs(); // Создает все необходимые родительские директории
            }

            // Сохранение файла в указанную директорию
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/photos/add?error=Failed+to+save+file"; // Возвращаем ошибку, если не удалось сохранить файл
        }

        // Создаем объект Photo и сохраняем его
        Photo photo = new Photo();
        photo.setUrl(filePath); // Ссылка на сохраненный файл
        photo.setHotel(new Hotel(hotelId));
        photo.setDescription(description);

        photoService.savePhoto(photo); // Сохраняем фото в базу данных

        return "redirect:/photos/hotel/" + hotelId; // Перенаправление на страницу с фотографиями отеля
    }


    // Метод для удаления фотографии
    @DeleteMapping("/delete/{photoId}")
    public String deletePhoto(@PathVariable Long photoId) {
        photoService.deletePhoto(photoId); // Удалить фотографию
        return "redirect:/photos"; // Или перенаправьте на другую страницу
    }
}
