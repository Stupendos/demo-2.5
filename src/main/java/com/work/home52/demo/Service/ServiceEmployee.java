package com.work.home52.demo.Service;
import com.work.home52.demo.Employee;
import com.work.home52.demo.exceptions.InvalidInputException;

import java.util.Collection;

public interface ServiceEmployee {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Collection<Employee> findAll();
}
