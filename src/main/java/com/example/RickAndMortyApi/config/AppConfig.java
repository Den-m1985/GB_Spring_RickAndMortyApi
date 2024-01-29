package com.example.RickAndMortyApi.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan("com/example/RickAndMortyApi/service")
public class AppConfig {

}
