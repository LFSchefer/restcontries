package co.simplon.rescontries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.rescontries.entities.Country;
import co.simplon.rescontries.services.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
	this.demoService = demoService;
    }

    @GetMapping("/derived")
    public List<Country> derived(int population, String country) {
	return demoService.derived(population, country);
    }

    @GetMapping("/sql")
    public List<Country> sql(int population, String country) {
	return demoService.sql(population, country);
    }

    @GetMapping("/jpql")
    public List<Country> jpql(int population, String country) {
	return demoService.jpql(population, country);
    }

    @GetMapping("/entity")
    public List<Country> entity(int population, String country) {
	return demoService.entity(population, country);
    }

    @GetMapping("/jdbc")
    public List<Country> jdbc(int population, String country) {
	return demoService.jdbc(population, country);
    }
}
