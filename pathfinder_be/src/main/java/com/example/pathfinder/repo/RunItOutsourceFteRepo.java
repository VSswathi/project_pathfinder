package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.RunItOutsourceFteDto;

@Repository
public interface RunItOutsourceFteRepo extends MongoRepository<RunItOutsourceFteDto, String>{

}
