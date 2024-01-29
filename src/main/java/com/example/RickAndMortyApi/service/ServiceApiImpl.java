package com.example.RickAndMortyApi.service;

import com.example.RickAndMortyApi.domain.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi{

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    private ResourcesProperties CHARACTER_API;

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String Url = CHARACTER_API.getApi();
        ResponseEntity<Characters> responce = template.exchange(Url, HttpMethod.GET,entity, Characters.class);

        return responce.getBody();
    }
}
