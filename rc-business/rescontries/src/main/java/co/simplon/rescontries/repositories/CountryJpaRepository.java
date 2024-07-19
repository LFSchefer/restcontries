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
   
    @Query(value = "select count(*) from t_countries", nativeQuery = true)
    Integer testQuery();
}
