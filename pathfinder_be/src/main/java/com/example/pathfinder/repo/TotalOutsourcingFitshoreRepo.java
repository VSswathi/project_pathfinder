package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;

@Repository
public interface TotalOutsourcingFitshoreRepo extends MongoRepository<TotalOutsourcingFitshoreDto, String>{

}