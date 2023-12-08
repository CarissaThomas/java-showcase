package com.example.myspringapi.repositories;

import com.example.myspringapi.entities.SuperHero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHeroRepository extends CrudRepository<SuperHero, Integer> {
    @Query("SELECT s FROM SuperHero s")
    List<SuperHero> findAllSuperHeroes();

    // Find SuperHeroes by First Name
    @Query("SELECT s FROM SuperHero s WHERE s.firstName = :firstName")
    List<SuperHero> findSuperHeroesByFirstName(@Param("firstName") String firstName);

    // Find SuperHeroes by Last Name
    @Query("SELECT s FROM SuperHero s WHERE s.lastName = :lastName")
    List<SuperHero> findSuperHeroesByLastName(@Param("lastName") String lastName);

    // Find SuperHeroes by Super Power
    @Query("SELECT s FROM SuperHero s WHERE s.superPower = :superPower")
    List<SuperHero> findSuperHeroesBySuperPower(@Param("superPower") String superPower);

    // Find SuperHeroes with a specific First Name and Last Name
    @Query("SELECT s FROM SuperHero s WHERE s.firstName = ?1 AND s.lastName = ?2")
    List<SuperHero> findSuperHeroesByFirstAndLastName(String firstName, String lastName);

    // Order SuperHeroes by Last Name
    @Query("SELECT s FROM SuperHero s ORDER BY s.lastName ASC")
    List<SuperHero> findAllSuperHeroesOrderedByLastName();
}
