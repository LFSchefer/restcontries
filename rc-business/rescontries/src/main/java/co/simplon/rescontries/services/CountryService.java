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

@Service
public class CountryService {

    private final CountryJpaRepository repository;

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

}
