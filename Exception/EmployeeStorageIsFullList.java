package com.homework19.HomeWork19.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullList extends Throwable {
    public EmployeeStorageIsFullList(String message) {
        super(message);
    }
}
