package com.homework19.HomeWork19.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedInList extends RuntimeException {
    public EmployeeAlreadyAddedInList(String message) {
        super(message);
    }
}
