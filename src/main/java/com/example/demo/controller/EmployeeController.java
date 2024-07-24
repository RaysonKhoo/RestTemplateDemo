package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeRespository;
    @CrossOrigin(origins = "*")
    @GetMapping("/employees")
    public List<Employee> fetchEmployees(){
        return employeRespository.findAll();
    }

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployees")
    public Employee get() {
        Employee userData = new Employee();
        userData.setId(1);
        userData.setFirstName("darshan");
        userData.setLastName("Babi");
        userData.setEmail("darshanBabi@gmail.com");
        return userData;
    }

    @PostMapping
    public ResponseEntity<Employee> post(@RequestBody Employee userData)
    {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(userData, headers,
                HttpStatus.CREATED);
    }
}
