package com.example.myspringapi.repositories;

import com.example.myspringapi.entities.SuperHero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends CrudRepository<SuperHero, Long> {

}
