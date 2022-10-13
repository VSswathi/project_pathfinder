package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.ItFunctionsDto;

@Repository
public interface ItFunctionsRepo extends MongoRepository<ItFunctionsDto, String> {

}
