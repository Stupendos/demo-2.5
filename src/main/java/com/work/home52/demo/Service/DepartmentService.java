package com.work.home52.demo.Service;

import com.work.home52.demo.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
     Employee maxSalary(Integer department);
     Employee minSalary(Integer department);
     List<Employee> allByDepartment( Integer department);
     Map<Integer, List<Employee>> getEmployeeByDepartment();
}
