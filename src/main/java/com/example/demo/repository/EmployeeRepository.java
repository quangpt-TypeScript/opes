package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    boolean existsByEmail(String email);

    @Query("{'_id': ?0}")
    Employee findOne(String id);

}
