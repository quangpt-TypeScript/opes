package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.model.LoginInfo;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/api")
    public ResponseEntity<String> testSpringBoot() {
        return ResponseEntity.ok("Success");
    }

    /**
     * get all employee
     */
    @GetMapping("/api/employee")
    public List<Employee> getEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    /**
     * get employee Info
     */
    @GetMapping("/api/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }

    /**
     * add employee data
     */
    @PostMapping("/api/employee")
    public ResponseEntity<String> addEmploye(@RequestBody Employee employee) {
        try {
            Employee e = employeeService.checkValidUser(employee);
            employeeRepository.insert(e);
            e.setMessage("OK");
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            Employee em = new Employee();
            em.setMessage("EXIST");
            return ResponseEntity.ok("Error");
        }
    }

}
