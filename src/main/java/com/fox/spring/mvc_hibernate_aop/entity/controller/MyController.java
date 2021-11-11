package com.fox.spring.mvc_hibernate_aop.entity.controller;

import com.fox.spring.mvc_hibernate_aop.entity.Employee;
import com.fox.spring.mvc_hibernate_aop.entity.dao.EmployeeDAO;
import com.fox.spring.mvc_hibernate_aop.entity.srevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(name = "/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }
    
    @RequestMapping(name = "/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping(name = "/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {


        employeeService.saveEmployee(employee);

        final var s = "redirect:/";
        return s;
    }
}

