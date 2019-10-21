package com.example.demo.repository;

import com.example.demo.model.LoginInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface LoginRepository extends MongoRepository<LoginInfo, String> {

    boolean existsByEmail(String email);

    @Query("{'_id': ?0}")
    LoginInfo findByEmail(String email);
}
