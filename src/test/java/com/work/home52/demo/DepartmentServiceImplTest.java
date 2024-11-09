package com.work.home52.demo;

import com.work.home52.demo.Service.DepartmentServiceImpl;
import com.work.home52.demo.Service.ServiceEmployeeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class DepartmentServiceImplTest {

    @Mock
    private ServiceEmployeeImpl serviceEmployeeImpl;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void maxSalary() {
        Employee emp1 = new Employee("Ivan", "Ivanov", 1, 3200);
        Employee emp2 = new Employee("Petr", "Petrov", 1, 2500);
        Employee emp3 = new Employee("Kolya", "Dub", 1, 3300);
        Employee emp4 = new Employee("Maria", "Luch", 2, 1700);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3);
        when(departmentService.allByDepartment(1)).thenReturn(employees);
        Employee maxSalaryEmp = departmentService.maxSalary(1);
        assertEquals("Kolya Dub", maxSalaryEmp.getFullName());
        assertEquals(3300, maxSalaryEmp.getSalary());
    }

    @Test
    void minSalary() {
        Employee emp1 = new Employee("Ivan", "Ivanov", 1, 3200);
        Employee emp2 = new Employee("Petr", "Petrov", 1, 2500);
        Employee emp3 = new Employee("Kolya", "Dub", 1, 3300);
        Employee emp4 = new Employee("Maria", "Luch", 2, 1700);
        Employee emp5 = new Employee("Ksenia", "Padal", 3, 1500);
        Employee emp6 = new Employee("Vitaliy", "Tsal", 2, 1640);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        when(departmentService.allByDepartment(2)).thenReturn(employees);
        Employee minSalaryEmp = departmentService.minSalary(2);
        assertEquals("Vitaliy Tsal", minSalaryEmp.getFullName());
        assertEquals(1640, minSalaryEmp.getSalary());
    }

    @Test
    void allByDepartment() {
        Employee emp1 = new Employee("Ivan", "Ivanov", 1, 3200);
        Employee emp2 = new Employee("Petr", "Petrov", 1, 2500);
        Employee emp3 = new Employee("Kolya", "Dub", 2, 3300);
        Employee emp4 = new Employee("Maria", "Luch", 2, 1700);
        Employee emp5 = new Employee("Ksenia", "Padal", 3, 1500);
        Employee emp6 = new Employee("Vitaliy", "Tsal", 2, 1640);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        when(departmentService.allByDepartment(1)).thenReturn(employees);
        List<Employee> allByDepartment = departmentService.allByDepartment(1);
        assertEquals(2, allByDepartment.size());
        assertEquals("Ivan Ivanov", allByDepartment.get(0).getFullName());
        assertEquals("Petr Petrov", allByDepartment.get(1).getFullName());
    }

    @Test
    void getEmployeeByDepartment() {
        Employee emp1 = new Employee("Ivan", "Ivanov", 1, 3200);
        Employee emp2 = new Employee("Petr", "Petrov", 1, 2500);
        Employee emp3 = new Employee("Kolya", "Dub", 2, 3300);
        Employee emp4 = new Employee("Maria", "Luch", 2, 1700);
        Employee emp5 = new Employee("Ksenia", "Padal", 3, 1500);
        Employee emp6 = new Employee("Vitaliy", "Tsal", 2, 1640);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        when(serviceEmployeeImpl.findAll()).thenReturn(employees);
        Map<Integer, List<Employee>> result = departmentService.getEmployeeByDepartment(1);
        assertEquals(3, result.size());
        assertEquals("Ivan Ivanov", result.get(1).get(0).getFullName());
        assertEquals("Petr Petrov", result.get(1).get(1).getFullName());
    }

    @Test
    void calculateSalarySumByDepartment() {
        Employee emp1 = new Employee("Ivan", "Ivanov", 1, 3200);
        Employee emp2 = new Employee("Petr", "Petrov", 1, 2500);
        Employee emp3 = new Employee("Kolya", "Dub", 2, 3300);
        Employee emp4 = new Employee("Maria", "Luch", 2, 1700);
        Employee emp5 = new Employee("Ksenia", "Padal", 3, 1500);
        Employee emp6 = new Employee("Vitaliy", "Tsal", 2, 1640);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        when(serviceEmployeeImpl.findAll()).thenReturn(employees);
        double sumSalary = departmentService.calculateSalarySumByDepartment(1);
        assertEquals(5700, sumSalary);
    }
}
