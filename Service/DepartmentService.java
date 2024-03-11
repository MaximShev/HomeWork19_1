package com.homework19.HomeWork19.Service;

import com.homework19.HomeWork19.Employee.Employee;
import com.homework19.HomeWork19.Exception.EmployeeNotFoundInList;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {
    private final EmployeeInterface employeeInterface;

    public DepartmentService(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeInterface.findCollection().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundInList("Сотрудник с максимальной зарплатой не найден"));
    }

    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeInterface.findCollection().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundInList("Сотрудник с минимальной зарплатой не найден"));
    }

    public Map<Integer, List<Employee>> getEmployeesByDepartment(Integer departmentId) {
        return employeeInterface.findCollection().stream()
                .filter(e -> departmentId == null || e.getDepartmentId() == departmentId)
                .collect(groupingBy(Employee::getDepartmentId, toList()));
    }

    public Map<Integer, List<Employee>> getEmployeesList() {
        return employeeInterface.findCollection().stream()
                .collect(groupingBy(Employee::getDepartmentId, toList()));
    }
}