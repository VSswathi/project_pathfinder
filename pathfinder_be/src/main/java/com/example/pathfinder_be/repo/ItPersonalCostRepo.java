package com.example.pathfinder_be.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
@Repository
public interface ItPersonalCostRepo extends MongoRepository<ItPersonalCostDto, Integer> {

	Optional<ItPersonnelDto> findById(String id);

}
