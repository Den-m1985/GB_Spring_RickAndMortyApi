package com.example.RickAndMortyApi.controller;

import com.example.RickAndMortyApi.domain.Characters;
import com.example.RickAndMortyApi.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/api")
    public ResponseEntity<Characters> getCharacters() {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

}
