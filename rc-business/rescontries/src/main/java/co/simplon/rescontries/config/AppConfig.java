package co.simplon.rescontries.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import co.simplon.rescontries.repositories.CountryJpaRepository;
import co.simplon.rescontries.services.CountryService;

@Configuration(proxyBeanMethods = false)
public class AppConfig {
/*
    @Bean
    public RestClient restClient() {
	return new RestClient.builder();
    }

    @Bean
    public CountryService countryService(RestClient restClient) {
	return new CountryService((CountryJpaRepository) restClient);
    }*/

}
