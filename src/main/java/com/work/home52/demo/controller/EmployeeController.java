package com.work.home52.demo.controller;

import com.work.home52.demo.Employee;
import com.work.home52.demo.Service.ServiceEmployee;
import com.work.home52.demo.exceptions.InvalidInputException;
import com.work.home52.demo.util.NameValidator;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.naming.InvalidNameException;
import java.util.Collection;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
    private final ServiceEmployee serviceEmployee;

    public EmployeeController(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (!NameValidator.validate(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return serviceEmployee.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (!NameValidator.validate(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return serviceEmployee.remove(firstName, lastName);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (!NameValidator.validate(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return serviceEmployee.find(firstName, lastName);
    }

    @GetMapping("/employee")
    public Collection<Employee> findAllEmployees() {
        return serviceEmployee.findAll();
    }
}
