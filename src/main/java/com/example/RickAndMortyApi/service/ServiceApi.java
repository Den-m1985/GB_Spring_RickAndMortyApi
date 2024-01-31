package com.example.RickAndMortyApi.service;


import com.example.RickAndMortyApi.domain.Characters;
import com.example.RickAndMortyApi.domain.Result;

public interface ServiceApi {
    public Characters getAllCharacters();
    Result getCharacterById(Integer id);
}
