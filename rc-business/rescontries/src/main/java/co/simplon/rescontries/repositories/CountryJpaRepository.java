package co.simplon.rescontries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.rescontries.dtos.CountryAdminView;
import co.simplon.rescontries.dtos.CountryView;
import co.simplon.rescontries.entities.Country;

@Repository
public interface CountryJpaRepository extends JpaRepository<Country, Long> {

//	findAll = SELECT *
//	ProjectedBy = only column for CountryView
//	OrderByCountryName = ORDER BY CountryName

    List<CountryView> findAllProjectedByOrderByCountryName();

    CountryView findProjectedById(Long id);

    List<CountryAdminView> findAllProjectedByOrderByIsoCode();

    boolean existsByIsoCodeIgnoreCase(String value);

    boolean existsByTldIgnoreCase(String value);

    List<Country> findByCountryPopulationGreaterThanAndCountryNameContainingOrderByCountryAreaDesc(int population,
	    String country);

    String SQL_QUERY = """
    	select * from t_countries
    	where country_population > :population
    	and country_name LIKE concat( '%', :country, '%')
    	order by country_area DESC
    	""";

    String JPQL_QUERY = """
    	select c from Country c
    	where countryPopulation > :population
    	and countryName LIKE concat( '%', :country, '%')
    	order by countryArea DESC
    	""";

    @Query(value = SQL_QUERY, nativeQuery = true)
    List<Country> sql(int population, String country);

    @Query(value = JPQL_QUERY)
    List<Country> jpql(int population, String country);

}
