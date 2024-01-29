package com.example.RickAndMortyApi.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "character")
@Data
public class ResourcesProperties {

    private String api;

}
