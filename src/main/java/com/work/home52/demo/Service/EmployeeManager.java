package com.work.home52.demo.Service;

import com.work.home52.demo.Employee;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private Map<String, Employee> employees;

    public EmployeeManager() {
        employees = new HashMap();
    }
    public boolean addEmployee(Employee employee) {
        String fullName = employee.getFullName();
        if (!employees.containsKey(fullName)) {
            employees.put(fullName, employee);
            return true;
        }
        return false;
    }
    public Employee getEmployee(String fullName) {
        return employees.get(fullName);
    }
    public boolean removeEmployee(String fullName) {
        return employees.remove(fullName) != null;
    }
    public void displayAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }

    }
}
