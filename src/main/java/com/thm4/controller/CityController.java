package com.thm4.controller;

import com.thm4.model.City;
import com.thm4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;
    @GetMapping("/listCity")
    public ResponseEntity<List<City>> listCity(){
        List<City> cityList = cityService.findAll();
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<City> createCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city){
        Optional<City> city1 = cityService.findById(id);
        if (city1.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            city.setId(city1.get().getId());
            return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id){
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id){
         Optional<City> city = cityService.findById(id);
        return city.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
