package com.homework19.HomeWork19.Controller;

import com.homework19.HomeWork19.Employee.Employee;
import com.homework19.HomeWork19.Service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class ControllerDepartment {
    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return "Код: " + e.getStatusCode() + ". Ошибка: " + e.getMessage();
    }

    private final DepartmentService departmentService;

    public ControllerDepartment(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Map<Integer, List<Employee>> getEmployeesByDepartment(@RequestParam(required = false) int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployeesList() {
        return departmentService.getEmployeesList();
    }
}