package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.LoginInfo;
import com.example.demo.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Log4j2
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    // Logger
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee checkValidUser(Employee request) throws Exception {
        log.debug(request);
        boolean checkEmployeeExist = employeeRepository.existsByEmail(request.getEmail());
        if (checkEmployeeExist) {
            throw new Exception("Email existed");
        }
        String id = String.valueOf(new Random().nextInt());
        Employee user = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .departmentId(request.getDepartmentId())
                .genderType(request.getGenderType())
                .id(request.getId())
                .build();
        return user;
    }
}
