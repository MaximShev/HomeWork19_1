package com.homework19.HomeWork19.Controller;

import com.homework19.HomeWork19.Employee.Employee;
import com.homework19.HomeWork19.Exception.EmployeeStorageIsFullList;
import com.homework19.HomeWork19.Exception.EmployeeAlreadyAddedInList;
import com.homework19.HomeWork19.Exception.EmployeeNotFoundInList;
import com.homework19.HomeWork19.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class ControllerEmployee {

    private final EmployeeService employeeService;

    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) throws EmployeeStorageIsFullList {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {

        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/allEmployees")
    public Collection<Employee> findCollecton() {
        return employeeService.findCollection();
    }
}
