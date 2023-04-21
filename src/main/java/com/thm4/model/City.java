package com.thm4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String nation;
    private Long population;
    private Long area;
    private Long Gdp;
    private String description;


    public City() {
    }

    public City(Long id, String city, String nation, Long population, Long area, Long gdp, String description) {
        this.id = id;
        this.city = city;
        this.nation = nation;
        this.population = population;
        this.area = area;
        Gdp = gdp;
        this.description = description;
    }

    public City(String city, String nation, Long population, Long area, Long Gdp, String description) {
        this.city = city;
        this.nation = nation;
        this.population = population;
        this.area = area;
        this.Gdp = Gdp;
        this.description = description;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGdp() {
        return Gdp;
    }

    public void setGdp(Long gdp) {
        Gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
