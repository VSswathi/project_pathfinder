package com.example.pathfinder_be.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.AssetClassificationDto;

@Repository
public interface AssetClassificationRepo extends MongoRepository<AssetClassificationDto, String >{


}
