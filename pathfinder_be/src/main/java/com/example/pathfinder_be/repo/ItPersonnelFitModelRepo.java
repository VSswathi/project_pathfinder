package com.example.pathfinder_be.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.ItPersonnelFitModelDto;
import com.example.pathfinder_be.dto.RunItOutsourceCostsDto;

@Repository
public interface ItPersonnelFitModelRepo extends MongoRepository<ItPersonnelFitModelDto, String> {

	RunItOutsourceCostsDto save(RunItOutsourceCostsDto obj4);

}