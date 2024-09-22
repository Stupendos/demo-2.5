package com.work.home52.demo.Service;
import com.work.home52.demo.Employee;
import com.work.home52.demo.exceptions.EmployeeAlreadyAddedException;
import com.work.home52.demo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final List<Employee> employeeList;

    public ServiceEmployeeImpl() {
        this.employeeList = new ArrayList<>( );
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employeeList.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employeeList.contains(employee)){
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employeeList.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
