package com.desin.kelala.restkelala.repository;

import com.desin.kelala.restkelala.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
