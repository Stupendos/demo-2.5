package com.work.home52.demo.controller;

import com.work.home52.demo.Employee;
import com.work.home52.demo.Service.ServiceEmployee;
import com.work.home52.demo.exceptions.InvalidInputException;
import com.work.home52.demo.util.NameValidator;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
    private final ServiceEmployee serviceEmployee;

    public EmployeeController(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, double salary) {
        if (!NameValidator.validate(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return serviceEmployee.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, double salary) {
        if (!NameValidator.validate(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return serviceEmployee.remove(firstName, lastName, department, salary);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, double salary) {
        if (!NameValidator.validate(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return serviceEmployee.find(firstName, lastName, department, salary);
    }

    @GetMapping()
    public Collection<Employee> findAllEmployees() {
        return serviceEmployee.findAll();
    }
}
