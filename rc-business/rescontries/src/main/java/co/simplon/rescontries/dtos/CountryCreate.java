package co.simplon.rescontries.dtos;

import co.simplon.rescontries.dtos.validators.UniqueIsoCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CountryCreate(@NotBlank @Size(min = 1, max = 80) String countryName,
	@Size(min = 1, max = 200) String countryCapital, @NotNull @Positive int countryPopulation,
	@NotNull @Positive float countryArea, @NotBlank @Size(min = 1, max = 120) String flagPng,
	@Size(max = 120) String coatOfArmsPng, @NotBlank @Size(min = 1, max = 120) String googleMap,
	@Size(min = 3, max = 3) String tld, @NotBlank @Size(min = 2, max = 2) @UniqueIsoCode String isoCode) {

}
