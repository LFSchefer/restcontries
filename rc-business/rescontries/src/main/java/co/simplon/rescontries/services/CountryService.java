package co.simplon.rescontries.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import co.simplon.rescontries.dtos.CountryAdminView;
import co.simplon.rescontries.dtos.CountryCreate;
import co.simplon.rescontries.dtos.CountryImport;
import co.simplon.rescontries.dtos.CountryView;
import co.simplon.rescontries.entities.Country;
import co.simplon.rescontries.repositories.CountryJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CountryService {

    private final CountryJpaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public CountryService(CountryJpaRepository repository) {
	this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CountryView> contryList() {
	return repository.findAllProjectedByOrderByCountryName();
    }

    public CountryView getOne(Long id) {
	return repository.findProjectedById(id);
    }

    public void create(CountryCreate inputs) {
	// Create a new Country object
	Country country = new Country();
	// Populate the entity with the 'validate' data from inputs (DTO)
	country.setCountryName(inputs.countryName());
	country.setCountryCapital(inputs.countryCapital());
	country.setTld(inputs.tld());
	country.setIsoCode(inputs.isoCode());

	country.setCoatOfArmsPng(inputs.coatOfArmsPng());
	country.setFlagPng(inputs.flagPng());
	country.setGoogleMap(inputs.googleMap());

	country.setCountryPopulation(inputs.countryPopulation());
	country.setCountryArea(inputs.countryArea());
	// Save/persist the new entity thanks to the repository
	repository.save(country);
    }

    public List<CountryAdminView> getAdminView() {
	return repository.findAllProjectedByOrderByIsoCode();
    }

    public boolean existByIsoCodeIgnoreCase(String value) {
	return repository.existsByIsoCodeIgnoreCase(value);
    }

    public boolean existsByTldIgnoreCase(String value) {
	return repository.existsByTldIgnoreCase(value);
    }

//    @Transactional
    public void importCountries() {
	RestClient restClient = RestClient.create();
	List<CountryImport> importedCountries = restClient.get().uri(
		"https://restcountries.com/v3.1/all?fields=name,capital,flags,tld,cca2,area,maps,population,coatOfArms")
		.retrieve().body(new ParameterizedTypeReference<>() {
		});
	List<Country> countryCandidate = new ArrayList<>();
	for (CountryImport countryImport : importedCountries) {

	    Country country = new Country();
	    country.setCountryName(countryImport.getCountryName());
	    country.setCountryCapital(countryImport.getCountryCapital());
	    country.setTld(countryImport.getTldImport());
	    country.setIsoCode(countryImport.getCca2());
	    country.setCoatOfArmsPng(countryImport.getArms());
	    country.setFlagPng(countryImport.getFlag());
	    country.setGoogleMap(countryImport.getMap());
	    country.setCountryPopulation(countryImport.getPopulation());
	    country.setCountryArea(countryImport.getArea());
	    countryCandidate.add(country);
	}
	repository.deleteAll();
	repository.saveAll(countryCandidate);

    }

    public List<Country> derived(int population, String country) {
	return repository.findByCountryPopulationGreaterThanAndCountryNameContainingOrderByCountryAreaDesc(population,
		country);
    }

    public List<Country> sql(int population, String country) {
	return repository.sql(population, country);
    }

    public List<Country> jpql(int population, String country) {
	return repository.jpql(population, country);
    }

    public List<Country> java(int population, String country) {
	return repository.findAll().stream()
		.filter(c -> c.getCountryPopulation() > population && c.getCountryName().contains(country))
		.sorted((o1, o2) -> (int) o2.getCountryArea() - (int) o1.getCountryArea()).toList();
    }

    private final static String SQL_QUERY = """
    	select * from t_countries
    	where country_population > :population
    	and country_name LIKE concat('%',:country,'%')
    	order by country_area DESC
    	""";

    public List<Country> entitySql(int population, String country) {
	return entityManager.createNativeQuery(SQL_QUERY, Country.class).setParameter("population", population)
		.setParameter("country", country).getResultList();
    }

    private final static String JPQL_QUERY = """
    	select c from Country c
    	where countryPopulation > :population
    	and countryName LIKE concat('%',:country,'%')
    	order by countryArea DESC
    	""";

    public List<Country> entityJpql(int population, String country) {
	return entityManager.createQuery(JPQL_QUERY, Country.class).setParameter("population", population)
		.setParameter("country", country).getResultList();
    }

}
