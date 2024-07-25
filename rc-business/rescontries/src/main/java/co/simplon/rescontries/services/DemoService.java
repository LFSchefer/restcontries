package co.simplon.rescontries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.rescontries.entities.Country;
import co.simplon.rescontries.repositories.CountryJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class DemoService {

    @PersistenceContext
    EntityManager entityManager;

    CountryJpaRepository repo;

    public DemoService(CountryJpaRepository repo) {
	this.repo = repo;
    }

    public List<Country> derived(int population, String country) {
	return repo.findByCountryPopulationGreaterThanAndCountryNameContainingOrderByCountryAreaDesc(population,
		country);
    }

    public List<Country> sql(int population, String country) {
	return repo.sql(population, country);
    }

    public List<Country> jpql(int population, String country) {
	return repo.jpql(population, country);
    }

    String JPQL_QUERY = """
    	select c from Country c
    	where countryPopulation > :population
    	and countryName LIKE concat( '%', :country, '%')
    	order by countryArea DESC
    	""";

    public List<Country> entity(int population, String country) {
	return entityManager.createQuery(JPQL_QUERY, Country.class).setParameter("population", population)
		.setParameter("country", country).getResultList();
    }

}
