package com.example.pathfinder_be.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.InputTablesDto;

@Repository
public interface InputTablesRepo extends MongoRepository<InputTablesDto, String>{

	InputTablesDto findById(InputTablesDto inp);

}
