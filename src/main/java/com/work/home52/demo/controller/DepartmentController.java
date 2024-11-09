package com.work.home52.demo.controller;


import com.work.home52.demo.Employee;
import com.work.home52.demo.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/max")
    public Employee maxSalary(@RequestParam Integer department) {
return departmentService.maxSalary(department);
    }
    @GetMapping("/{id}/salary/min")
    public Employee minSalary(@RequestParam Integer department) {
return departmentService.minSalary(department);
    }
    @GetMapping("/{id}/employees")
    public List<Employee> allByDepartment(@RequestParam Integer department) {
        return departmentService.allByDepartment(department);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeeByDepartment(Integer department) {
return departmentService.getEmployeeByDepartment(department);
    }
    @GetMapping("/{id}/salary/sum")
    public ResponseEntity<Double> getSalarySumByDepartment(@PathVariable Integer department) {
        double salarySum = departmentService.calculateSalarySumByDepartment(department);
        return ResponseEntity.ok(salarySum);
    }

}
