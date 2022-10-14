package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.TotalSavingsModel2BDto;

@Repository
public interface TotalSavingsModel2BRepo extends MongoRepository<TotalSavingsModel2BDto, String>{

}
