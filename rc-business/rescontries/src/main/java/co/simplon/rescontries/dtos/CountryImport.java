package co.simplon.rescontries.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryImport {

    private String cca2;
    private String tldImport;
    private String countryCapital;
    private float area;
    private int population;
    private String countryName;
    private String flag;
    private String arms;
    private String map;

    @JsonProperty("capital")
    private void unpackNestedCapital(List<String> capital) {

	this.countryCapital = !capital.isEmpty() ? capital.get(0) : null;
    }

    @JsonProperty("tld")
    private void unpackNestedTldImport(List<String> tld) {

	this.tldImport = !tld.isEmpty() ? tld.get(0) : null;
    }

    @JsonProperty("name")
    private void unpackNestedName(Map<String, Object> name) {
	this.countryName = (String) name.get("official");
    }

    @JsonProperty("flags")
    private void unpackNestedFlag(Map<String, Object> flags) {
	this.flag = (String) flags.get("png");
    }

    @JsonProperty("coatOfArms")
    private void unpackNestedArms(Map<String, Object> coatOfArms) {
	this.arms = (String) coatOfArms.get("png");
    }

    @JsonProperty("maps")
    private void unpackNestedMap(Map<String, Object> maps) {
	this.map = (String) maps.get("googleMaps");
    }

    public CountryImport(String cca2, String tldImport, String countryCapital, float area, int population,
	    String countryName, String flag, String arms, String map) {
	this.cca2 = cca2;
	this.tldImport = tldImport;
	this.countryCapital = countryCapital;
	this.area = area;
	this.population = population;
	this.countryName = countryName;
	this.flag = flag;
	this.arms = arms;
	this.map = map;
    }

    @Override
    public String toString() {
	return "{cca2=" + cca2 + ", tldImport=" + tldImport + ", countryCapital=" + countryCapital + ", area=" + area
		+ ", population=" + population + ", countryName=" + countryName + ", flag=" + flag + ", arms=" + arms
		+ ", map=" + map + "}";
    }

    public String getCca2() {
	return cca2;
    }

    public void setCca2(String cca2) {
	this.cca2 = cca2;
    }

    public String getTldImport() {
	return tldImport;
    }

    public void setTldImport(String tldImport) {
	this.tldImport = tldImport;
    }

    public String getCountryCapital() {
	return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
	this.countryCapital = countryCapital;
    }

    public float getArea() {
	return area;
    }

    public void setArea(float area) {
	this.area = area;
    }

    public int getPopulation() {
	return population;
    }

    public void setPopulation(int population) {
	this.population = population;
    }

    public String getCountryName() {
	return countryName;
    }

    public void setCountryName(String countryName) {
	this.countryName = countryName;
    }

    public String getFlag() {
	return flag;
    }

    public void setFlag(String flag) {
	this.flag = flag;
    }

    public String getArms() {
	return arms;
    }

    public void setArms(String arms) {
	this.arms = arms;
    }

    public String getMap() {
	return map;
    }

    public void setMap(String map) {
	this.map = map;
    }

}
