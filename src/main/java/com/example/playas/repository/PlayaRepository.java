package com.example.playas.repository;

import com.example.playas.model.Playa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayaRepository extends MongoRepository<Playa, String> {
}
