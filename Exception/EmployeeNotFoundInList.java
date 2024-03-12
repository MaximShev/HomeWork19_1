package com.homework19.HomeWork19.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)

public class EmployeeNotFoundInList extends RuntimeException {
    public EmployeeNotFoundInList(String message) {
        super(message);
    }
}
