package com.example.demo.services;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    private final RestTemplate restTemplate;


    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method
    public Employee getUserData()
    {
        return restTemplate.getForObject(
                "http://localhost:8080/api/getEmployees",
                Employee.class);
    }

    public ResponseEntity<Employee> post(Employee user)
    {

        return restTemplate.postForEntity(
                "http://localhost:8080/api", user,
                Employee.class, "");
    }
}
