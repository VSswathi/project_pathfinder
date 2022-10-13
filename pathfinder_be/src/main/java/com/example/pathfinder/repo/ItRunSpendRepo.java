package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.ItRunSpendDto;

@Repository
public interface ItRunSpendRepo  extends MongoRepository<ItRunSpendDto, String> {

}
