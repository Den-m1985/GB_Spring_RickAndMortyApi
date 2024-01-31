package com.example.RickAndMortyApi.service;

import com.example.RickAndMortyApi.domain.Characters;
import com.example.RickAndMortyApi.domain.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi {
    private RestTemplate template;
    private HttpHeaders headers;
    private ResourcesProperties CHARACTER_API;


    /**
     * Метод для получения всех персонажей из внешнего API.
     * Устанавливает заголовки и отправляет GET-запрос к API.
     *
     * @return Объект Characters, представляющий результат запроса, содержащий информацию
     *         о списке персонажей и дополнительные свойства.
     */
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String Url = CHARACTER_API.getApi();
        ResponseEntity<Characters> response = template.exchange(Url, HttpMethod.GET, entity, Characters.class);

        return response.getBody();
    }


    /**
     * Метод для получения информации о персонаже по его уникальному идентификатору (ID) из внешнего API.
     * Устанавливает заголовки и отправляет GET-запрос к API, включая ID персонажа в URL.
     *
     * @param id Уникальный идентификатор персонажа.
     * @return Объект Result, представляющий информацию о персонаже, полученную в результате запроса.
     *         Возвращается null, если персонаж с указанным ID не найден.
     */
    @Override
    public Result getCharacterById(Integer id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = CHARACTER_API.getApi() + "/" + id;  // Добавляем ID к URL

        ResponseEntity<Result> response = template.exchange(url, HttpMethod.GET, entity, Result.class);
        return response.getBody();
    }

}
