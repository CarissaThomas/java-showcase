package com.example.myspringapi.controllers;

import com.example.myspringapi.entities.SuperHero;
import com.example.myspringapi.entities.SuperReport;
import com.example.myspringapi.repositories.SuperHeroRepository;
import com.example.myspringapi.repositories.SuperReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/heroData")
public class SuperHeroController {
    private final SuperHeroRepository superHeroRepository;
    private final SuperReportRepository superReportRepository;

    @Autowired
    public SuperHeroController(SuperHeroRepository superHeroRepository, SuperReportRepository superReportRepository) {
        this.superHeroRepository = superHeroRepository;
        this.superReportRepository = superReportRepository;
    }

    @GetMapping("superHero")
    public Iterable<SuperHero> getSuperHeros() {
        Iterable<SuperHero> superHeroes = superHeroRepository.findAll();
        return superHeroes;
    }

    @GetMapping("superHero/{firstName}")
    public List<SuperHero> getSuperHeroByFirstName(@PathVariable("firstName") String firstName) {
        return superHeroRepository.findSuperHeroesByFirstName(firstName);
    }

    @GetMapping("superHero/firstName/{id}")
    public Optional<SuperHero> getSuperHeroById(@PathVariable("id") int id) {
        return superHeroRepository.findById(id);
    }

    @GetMapping("superReport/{id}")
    public Optional<SuperReport> getSuperReportById(@PathVariable("id") int id) {
        return superReportRepository.findById(id);
    }

    @PostMapping(path = "/addNew")
    public String createNewSuperHero(@RequestBody SuperHero superHero) {
        superHeroRepository.save(superHero);
        return "New Super Hero successfully added!";
    }

    @PostMapping(path = "/help")
    public String postHelp(@RequestParam String postalCode, @RequestParam String streetAddress) {
        SuperReport newSuperReport = new SuperReport(postalCode, streetAddress);
        superReportRepository.save(newSuperReport);
        return postalCode;
    }
}