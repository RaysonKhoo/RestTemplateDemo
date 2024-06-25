package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ConsumeApi")
public class ConsumeApiController {
    @Autowired
    private final EmployeeService employeeService;


    public ConsumeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("user", employeeService.getUserData());
        model.addAttribute("model", new Employee());
        return "AddData";
    }

    @PostMapping
    public String post(@ModelAttribute("model") Employee employee, Model model)
    {
        ResponseEntity<Employee> response = employeeService.post(employee);

        model.addAttribute("user", response.getBody());
        model.addAttribute("headers",
                response.getHeaders() + " "
                        + response.getStatusCode());
        return "GetData";
    }
}
