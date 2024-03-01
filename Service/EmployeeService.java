package com.homework19.HomeWork19.Service;

import com.homework19.HomeWork19.Employee.Employee;
import com.homework19.HomeWork19.Exception.EmployeeAlreadyAddedInList;
import com.homework19.HomeWork19.Exception.EmployeeNotFoundInList;
import com.homework19.HomeWork19.Exception.EmployeeStorageIsFullList;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeInterface {

    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }
    private final int STORAGE_SIZE = 15;

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeStorageIsFullList, EmployeeAlreadyAddedInList {
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullList("Превышено максимально количество сотрудников");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedInList("Сотрудник уже в списке");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundInList {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundInList("Такой сотрудник отсутствует в компании");
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundInList {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundInList("Такой сотрудник отсутствует в компании");
    }

    @Override
    public Collection<Employee> findCollection() {
        return Collections.unmodifiableCollection(employees.values());
    }
}