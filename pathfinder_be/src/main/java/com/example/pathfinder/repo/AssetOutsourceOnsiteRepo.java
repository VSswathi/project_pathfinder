package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;

@Repository
public interface AssetOutsourceOnsiteRepo extends MongoRepository<AssetOutsourceOnsiteDto, String> {

}
