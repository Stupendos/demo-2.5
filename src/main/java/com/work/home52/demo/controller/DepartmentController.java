package com.work.home52.demo.controller;


import com.work.home52.demo.Employee;
import com.work.home52.demo.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer department) {
return departmentService.maxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer department) {
return departmentService.minSalary(department);
    }
    @GetMapping("/allByDepartment")
    public List<Employee> allByDepartment(@RequestParam Integer department) {
        return departmentService.allByDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployeeByDepartment() {
return departmentService.getEmployeeByDepartment();
    }

}
