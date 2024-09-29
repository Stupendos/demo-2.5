package com.work.home52.demo.Service;
import com.work.home52.demo.Employee;
import com.work.home52.demo.exceptions.EmployeeAlreadyAddedException;
import com.work.home52.demo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final Map<String, Employee> employees;

    public ServiceEmployeeImpl() {
        this.employees = new HashMap<>() {
        };
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.containsKey(employee.getFullName())){
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.containsKey(employee.getFullName())){
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
