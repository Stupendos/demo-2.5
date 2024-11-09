package com.work.home52.demo;

import com.work.home52.demo.Service.ServiceEmployeeImpl;
import com.work.home52.demo.exceptions.EmployeeAlreadyAddedException;
import com.work.home52.demo.exceptions.EmployeeNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {


    private ServiceEmployeeImpl serviceEmployeeImpl;
    private HashMap<String, Employee> employees;

    @BeforeEach
    void setUp() {
            this.serviceEmployeeImpl = new ServiceEmployeeImpl();
    }


    @Test
    void add() {
        Employee employee = serviceEmployeeImpl.add("Ivan", "Ivanov", 1, 213.4);
        assertNotNull(employee);
        assertEquals("Ivan Ivanov", employee.getFullName());
        assertEquals(1, employee.getDepartment());
        assertEquals(213.4, employee.getSalary());
    }

    @Test
    void addDuplicateEmployee() {
        serviceEmployeeImpl.add("Ivan", "Ivanov", 1, 213.4);
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                serviceEmployeeImpl.add("Ivan", "Ivanov", 1, 213.4));
    }
    @Test
    void remove() {
        serviceEmployeeImpl.add("Ivan", "Ivanov", 1, 213.4);
        Employee removedEmployee = serviceEmployeeImpl.remove("Ivan", "Ivanov", 2, 2451.2);
        assertNotNull(removedEmployee);
        assertEquals("Ivan Ivanov", removedEmployee.getFullName());
        assertThrows(EmployeeNotFoundException.class, () ->
                serviceEmployeeImpl.remove("Ivan", "Ivanov", 2, 2451.2));
    }

    @Test
    void find() {
        serviceEmployeeImpl.add("Ivan", "Ivanov", 1, 213.4);
        Employee foundEmployee = serviceEmployeeImpl.find("Ivan", "Ivanov", 1, 213.4);
        assertNotNull(foundEmployee);
        assertEquals("Ivan Ivanov", foundEmployee.getFullName());
    }
    @Test
    void testFindNonExistentEmployee() {
        assertThrows(EmployeeNotFoundException.class,()->{
            serviceEmployeeImpl.find("Ivan", "Ivanov", 1, 213.4);
        });
    }
    @Test
    void findAll() {
        serviceEmployeeImpl.add("Ivan", "Ivanov", 1, 213.4);
        serviceEmployeeImpl.add("Petr", "Petrov", 2, 251.4);
        Collection<Employee> employees = serviceEmployeeImpl.findAll();
        assertEquals(2, employees.size());
    }
}
