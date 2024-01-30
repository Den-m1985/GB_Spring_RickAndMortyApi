package com.example.RickAndMortyApi.controller;

import com.example.RickAndMortyApi.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerAPI {

    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String getMain(Model model) {
        model.addAttribute("results", serviceApi.getAllCharacters().getResults());
        return "index";
    }

}
