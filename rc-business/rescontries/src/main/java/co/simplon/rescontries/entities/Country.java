package co.simplon.rescontries.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "t_countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_capital")
    private String countryCapital;
    @Column(name = "country_population")
    private int countryPopulation;
    @Column(name = "country_area")
    private float countryArea;
    @Column(name = "flag_png")
    private String flagPng;
    @Column(name = "coat_of_arms_png")
    private String coatOfArmsPng;
    @Column(name = "google_map")
    private String googleMap;
    @Column(name = "tld")
    private String tld;
    @Column(name = "iso_code")
    private String isoCode;

    public Country() {
	// require by ORM
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getCountryName() {
	return countryName;
    }

    public void setCountryName(String countryName) {
	this.countryName = countryName;
    }

    public String getCountryCapital() {
	return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
	this.countryCapital = countryCapital;
    }

    public int getCountryPopulation() {
	return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
	this.countryPopulation = countryPopulation;
    }

    public float getCountryArea() {
	return countryArea;
    }

    public void setCountryArea(float countryArea) {
	this.countryArea = countryArea;
    }

    public String getFlagPng() {
	return flagPng;
    }

    public void setFlagPng(String flagPng) {
	this.flagPng = flagPng;
    }

    public String getCoatOfArmsPng() {
	return coatOfArmsPng;
    }

    public void setCoatOfArmsPng(String coatOfArmsPng) {
	this.coatOfArmsPng = coatOfArmsPng;
    }

    public String getGoogleMap() {
	return googleMap;
    }

    public void setGoogleMap(String googleMap) {
	this.googleMap = googleMap;
    }

    public String getTld() {
	return tld;
    }

    public void setTld(String tld) {
	this.tld = tld;
    }

    public String getIsoCode() {
	return isoCode;
    }

    public void setIsoCode(String isoCode) {
	this.isoCode = isoCode;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", countryName=" + countryName + ", countryCapital=" + countryCapital
		+ ", countryPopulation=" + countryPopulation + ", countryArea=" + countryArea + ", flagPng=" + flagPng
		+ ", coatOfArmsPng=" + coatOfArmsPng + ", googleMap=" + googleMap + ", tld=" + tld + ", isoCode="
		+ isoCode + "}";
    }

}
