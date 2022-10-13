package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.AssetClassificationHardwareDto;


@Repository
public interface AssetClassificationHardwareRepo extends MongoRepository<AssetClassificationHardwareDto, String>{



}
