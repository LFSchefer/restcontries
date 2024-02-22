package co.simplon.rescontries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.rescontries.dtos.Country;
import co.simplon.rescontries.services.CountryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RescountriesController {

    private final CountryService service;

    public RescountriesController(CountryService service) {
	this.service = service;
    }

    @GetMapping("/test")
    String test() {
	return "coucou";
    }

    @GetMapping("/country")
    Country getContry() {
	return service.country();
    }

    @GetMapping("/countries")
    List<Country> getContries() {
	return service.contryList();
    }

}
