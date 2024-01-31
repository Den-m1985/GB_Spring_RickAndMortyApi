package com.example.RickAndMortyApi.controller;

import com.example.RickAndMortyApi.domain.Result;
import com.example.RickAndMortyApi.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerAPI {

    @Autowired
    private ServiceApi serviceApi;


    /**
     * Обработчик GET-запроса для главной страницы.
     * Получает список всех персонажей из внешнего API и передает его в модель для отображения на главной странице.
     *
     * @param model Объект Model для передачи данных в представление.
     * @return Название представления ("index"), которое будет отображено.
     */
    @GetMapping("/")
    public String getMain(Model model) {
        model.addAttribute("results", serviceApi.getAllCharacters().getResults());
        return "index";
    }


    /**
     * Обработчик GET-запроса для страницы с подробной информацией о персонаже.
     * Получает информацию о персонаже по его уникальному идентификатору (ID) из внешнего API,
     * добавляет эту информацию в модель и возвращает название представления для отображения.
     *
     * @param id    Уникальный идентификатор персонажа.
     * @param model Объект Model для передачи данных в представление.
     * @return Название представления ("character"), которое будет отображено для выбранного персонажа.
     */
    @GetMapping("/character/{id}")
    public String getCharacter(@PathVariable Integer id, Model model) {
        Result selectedCharacter = serviceApi.getCharacterById(id);
        model.addAttribute("character", selectedCharacter);
        return "character";
    }

}
