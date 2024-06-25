package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception{
		Employee employee1 = Employee.builder().firstName("ABC").lastName("store").email("ABC@gmail.com").build();
		Employee employee2 = Employee.builder().firstName("DEF").lastName("market").email("DEF@gmail.com").build();

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}
}
