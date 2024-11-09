package com.work.home52.demo.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Превышен лимит сотрудников в фирме");
    }
}
