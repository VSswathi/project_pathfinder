package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.UserValuesDto;

@Repository
public interface UserValuesRepo extends MongoRepository<UserValuesDto, String> {

}