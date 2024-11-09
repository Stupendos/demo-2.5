package com.work.home52.demo.Service;
import com.work.home52.demo.Employee;

import java.util.Collection;

public interface ServiceEmployee {

    Employee add(String firstName, String lastName, int department, double salary);
    Employee remove(String firstName, String lastName, int department, double salary);
    Employee find(String firstName, String lastName, int department, double salary);
    Collection<Employee> findAll();

}
