package com.example.myspringapi.repositories;

import com.example.myspringapi.entities.SuperReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperReportRepository extends CrudRepository<SuperReport, Integer> {

}