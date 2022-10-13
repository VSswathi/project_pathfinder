package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;

@Repository
public interface ItSpendOnRunPersonnelRepo extends MongoRepository<ItSpendOnRunPersonnelDto, String> {

}
