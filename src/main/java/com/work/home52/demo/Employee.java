package com.work.home52.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
@Data

public class Employee {
    private final String firstName;
    private final String lastName;
    private double salary;
    private int department;

    public Employee(String firstName, String lastName) {
        this.firstName = StringUtils.capitalize(firstName);
        this.lastName = StringUtils.capitalize(lastName);
    }

    public Employee(String firstName, String lastName, double salary, int department) {
        this.firstName = StringUtils.capitalize(firstName);
        this.lastName = StringUtils.capitalize(lastName);
        this.salary = salary;
        this.department = department;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}

