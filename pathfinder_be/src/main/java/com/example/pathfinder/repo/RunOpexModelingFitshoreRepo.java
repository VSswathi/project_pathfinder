package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;

@Repository
public interface RunOpexModelingFitshoreRepo extends MongoRepository<RunOpexModelingFitshoreDto, String>{

}
