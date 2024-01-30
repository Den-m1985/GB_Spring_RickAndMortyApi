package com.example.RickAndMortyApi.service;

import com.example.RickAndMortyApi.domain.Characters;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi {
    private RestTemplate template;
    private HttpHeaders headers;
    private ResourcesProperties CHARACTER_API;


    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String Url = CHARACTER_API.getApi();
        ResponseEntity<Characters> responce = template.exchange(Url, HttpMethod.GET, entity, Characters.class);

        return responce.getBody();
    }

}
