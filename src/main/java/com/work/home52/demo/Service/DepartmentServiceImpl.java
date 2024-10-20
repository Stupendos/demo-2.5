package com.work.home52.demo.Service;

import com.work.home52.demo.Employee;
import com.work.home52.demo.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final ServiceEmployee serviceEmployee;

    public DepartmentServiceImpl(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @Override
    public Employee maxSalary(Integer department) {
        return serviceEmployee.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minSalary(Integer department) {
        return serviceEmployee.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> allByDepartment(Integer department) {
        return serviceEmployee.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeeByDepartment() {
        return serviceEmployee.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
