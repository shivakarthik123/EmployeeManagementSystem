package com.luv2code.springboot.demosecurity.controller;

import com.luv2code.springboot.demosecurity.entity.Employee;
import com.luv2code.springboot.demosecurity.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class demoController {
    private EmployeeService employeeservice;
    public demoController(EmployeeService theEmployeeService){
        employeeservice=theEmployeeService;
    }
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    // add a request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders(Model theModel){
        List<Employee> theEmployees=employeeservice.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "list-employees-manager";
    }
    @GetMapping("/systems")
    public String showSystems(Model theModel){
        List<Employee> theEmployees=employeeservice.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
