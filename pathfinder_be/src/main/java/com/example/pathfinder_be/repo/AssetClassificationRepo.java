package com.example.pathfinder_be.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.AssetClassificationDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareDto;
import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.dto.YearBasedTransformationDto;

@Repository
public interface AssetClassificationRepo extends MongoRepository<AssetClassificationDto, String >{


}
