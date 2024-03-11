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
        this.employees = new HashMap<>(Map.of(
                "1", new Employee("Сергей", "Иванов", 87653, 1),
                "2", new Employee("Василий", "Васильев", 84654, 2),
                "3", new Employee("Семен", "Сергеев", 79515, 3),
                "4", new Employee("Пётр", "Петров", 54873, 4),
                "5", new Employee("Илья", "Семенов", 54654, 5),
                "6", new Employee("Джон", "Уайт", 86579, 1)));
    }
    private final int STORAGE_SIZE = 15;

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) throws EmployeeStorageIsFullList, EmployeeAlreadyAddedInList {
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullList("Превышено максимально количество сотрудников");
        }
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedInList("Сотрудник уже в списке");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int departmentId) throws EmployeeNotFoundInList {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundInList("Такой сотрудник отсутствует в компании");
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int departmentId) throws EmployeeNotFoundInList {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
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