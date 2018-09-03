package com.desin.kelala.restkelala.repository;

import com.desin.kelala.restkelala.entity.HealthRepresentative;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HealthRepresentativeRepository extends MongoRepository<HealthRepresentative, String> {
}
