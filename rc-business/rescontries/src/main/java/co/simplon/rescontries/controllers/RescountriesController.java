package co.simplon.rescontries.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.rescontries.dtos.CountryAdminView;
import co.simplon.rescontries.dtos.CountryCreate;
import co.simplon.rescontries.dtos.CountryView;
import co.simplon.rescontries.services.CountryService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/countries")
public class RescountriesController {

    private final CountryService service;

    public RescountriesController(CountryService service) {
	this.service = service;
    }

    @GetMapping("/test")
    String test() {
	return "coucou";
    }

    @GetMapping("/all")
    List<CountryView> getContries() {
	return service.contryList();
    }

    @GetMapping("/{id}")
    CountryView getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void create(@RequestBody @Valid CountryCreate inputs) {
	service.create(inputs);
    }

    @GetMapping("/admin")
    List<CountryAdminView> getAdminView() {
	return service.getAdminView();
    }

    @GetMapping("/import")
    void importCountries() {
	service.importCountries();
    }

}
