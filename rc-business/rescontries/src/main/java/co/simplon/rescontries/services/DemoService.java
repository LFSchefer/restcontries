package co.simplon.rescontries.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

    public List<Country> jdbc(int population, String country) {
	List<Country> countryList = new ArrayList<>();
	String query = String.format(
		"select * from t_countries where country_population > %s and country_name LIKE concat('%%','%s','%%') order by country_area DESC",
		population, country);
	try {
	    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restcountries", "postgres",
		    "postgres");
	    Statement stmt = con.createStatement();
	    ResultSet resultSet = stmt.executeQuery(query);
	    while (resultSet.next()) {
		Country countryResult = new Country();
		countryResult.setId(resultSet.getLong("id"));
		countryResult.setFlagPng(resultSet.getString("flag_png"));
		countryResult.setCountryCapital(resultSet.getString("country_capital"));
		countryResult.setCountryPopulation(resultSet.getInt("country_population"));
		countryResult.setCountryName(resultSet.getString("country_name"));
		countryResult.setCountryArea(resultSet.getFloat("country_area"));
		countryResult.setTld(resultSet.getString("tld"));
		countryResult.setIsoCode(resultSet.getString("iso_code"));
		countryResult.setCoatOfArmsPng(resultSet.getString("coat_of_arms_png"));
		countryResult.setGoogleMap(resultSet.getString("google_map"));
		countryList.add(countryResult);
	    }
	    resultSet.close();
	    stmt.close();
	    con.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
	return countryList;
    }

}
