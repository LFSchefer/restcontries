package co.simplon.rescontries.services;

import org.springframework.stereotype.Service;

import co.simplon.rescontries.repositories.CountryJpaRepository;

@Service
public class DemoService {

    CountryJpaRepository repo;

    public DemoService(CountryJpaRepository repo) {
	this.repo = repo;
    }

}
