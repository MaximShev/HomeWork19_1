package com.homework19.HomeWork19.Service;

import com.homework19.HomeWork19.Employee.Employee;
import com.homework19.HomeWork19.Exception.EmployeeAlreadyAddedInList;
import com.homework19.HomeWork19.Exception.EmployeeNotFoundInList;
import com.homework19.HomeWork19.Exception.EmployeeStorageIsFullList;

import java.util.Collection;
import java.util.List;

public interface EmployeeInterface {

    Employee add(String firstName, String lastName, int salary, int departmentId) throws EmployeeStorageIsFullList, EmployeeAlreadyAddedInList;

    Employee remove(String firstName, String lastName, int salary, int departmentId) throws EmployeeNotFoundInList;

    Employee find(String firstName, String lastName, int salary, int departmentId) throws EmployeeNotFoundInList;

    Collection<Employee> findCollection();
}
