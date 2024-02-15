package com.homework19.HomeWork19.Service;

import com.homework19.HomeWork19.Employee.Employee;
import com.homework19.HomeWork19.Exception.EmployeeAlreadyAddedInList;
import com.homework19.HomeWork19.Exception.EmployeeNotFoundInList;
import com.homework19.HomeWork19.Exception.EmployeeStorageIsFullList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    private final int STORAGE_SIZE = 15;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Овидий", "Королёв"),
            new Employee("Тихон", "Шилов"),
            new Employee("Лана", "Кабанова"),
            new Employee("Мирра", "Князева"),
            new Employee("Антон", "Муравьёв"),
            new Employee("Степан", "Давыдов"),
            new Employee("Рамина", "Степанова"),
            new Employee("Марина", "Евдокимова"),
            new Employee("Хильда", "Михайлова"),
            new Employee("Самуил", "Козлов")));

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeStorageIsFullList, EmployeeAlreadyAddedInList {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedInList("Сотрудник уже в списке");
        }
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullList("Превышено максимально количество сотрудников");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundInList {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundInList("Такой сотрудник отсутствует в компании");
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundInList {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundInList("Такой сотрудник отсутствует в компании");
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}