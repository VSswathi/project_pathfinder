package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.YearBasedOutsourcingDto;
@Repository
public interface YearBasedOutsourcingRepo extends MongoRepository<YearBasedOutsourcingDto, Long> {

}
