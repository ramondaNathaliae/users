package com.protectedobjects.users.controller;

import com.protectedobjects.users.model.Country;
import com.protectedobjects.users.repository.CountryRepository;
import com.protectedobjects.users.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1.0/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CountryService countryService;

    @GetMapping("/{id}")
    Optional<?> getCountryById(@PathVariable("id") Long countryId) {
        return countryRepository.findById(countryId);
    }

    @GetMapping
    List getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping({"/showCountries", "/countries"})
    ModelAndView getAllCountriesView() {
        ModelAndView view = new ModelAndView("all-countries");
        view.addObject("countries", countryRepository.findAllByOrderByNameAsc());
        return view;
    }

    @GetMapping({"/createCountry"})
    public ModelAndView getCreateCountryView() {
        ModelAndView view = new ModelAndView("add-country-form");
        view.addObject("country", new Country());
        return view;
    }

    @GetMapping({"/updateCountry"})
    public ModelAndView getUpdateCountryView(@RequestParam Long countryId) {
        ModelAndView view = new ModelAndView("add-country-form");
        Country country = countryRepository.findById(countryId).get();
        view.addObject("country", country);
        return view;
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok(countryRepository.save(country));
    }

    @PostMapping({"/createNewCountry"})
    public String createNewCountry(@ModelAttribute Country country) {
        Country newCountry = countryRepository.save(country);
        return "redirect:/api/v1.0/country/showCountries";
    }

    @GetMapping({"/deleteCountry"})
    public String deleteCountry(@RequestParam Long countryId) {
        countryRepository.deleteById(countryId);
        return "redirect:/api/v1.0/country/showCountries";
    }
}

