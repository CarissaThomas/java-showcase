package com.myspringapi.controller;

import com.myspringapi.models.SuperHero;
import com.myspringapi.models.SuperReport;
import com.myspringapi.repositories.SuperHeroRepository;
import com.myspringapi.repositories.SuperReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/superHeroes")
public class SuperHeroController {

    private final SuperHeroRepository superHeroRepository;
    private final SuperReportRepository superReportRepository;

    @Autowired
    public SuperHeroController(SuperHeroRepository superHeroRepository, SuperReportRepository superReportRepository) {
        this.superHeroRepository = superHeroRepository;
        this.superReportRepository = superReportRepository;
    }

    @GetMapping()
    public Iterable<SuperHero> getSuperHeros() {
        Iterable<SuperHero> superHeroes = superHeroRepository.findAll();
        return superHeroes;
    }

    @GetMapping(path="/{postalCode}")
    public Iterable<SuperReport> getHeroReportByPostal(@PathVariable String postalCode) {
        Iterable<SuperReport> superReport = superReportRepository.findByPostalCode(postalCode);
        int counter = 0;
        for (SuperReport a : superReport) {
            counter++;
        }
        if (counter < 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report Not Found. Please try a different postal code.");
        }
        return superReport;
    }

    @PostMapping(path="/addNew")
    public String createNewSuperHero(@RequestBody SuperHero superHero) {
        superHeroRepository.save(superHero);
        return "New Super Hero successfully added!";
    }

    @PostMapping(path="/help")
    public String postHelp(@RequestParam String postalCode, @RequestParam String streetAddress) {
        SuperReport newSuperReport = new SuperReport(postalCode, streetAddress);
        superReportRepository.save(newSuperReport);
    }
}
