package com.example.pathfinder_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class PathfinderBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathfinderBeApplication.class, args);
	}

}
