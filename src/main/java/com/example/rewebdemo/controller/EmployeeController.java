package com.example.rewebdemo.controller;

import com.example.rewebdemo.Entity.Employee;
import com.example.rewebdemo.dto.CreateEmployeeRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateEmployeeRequest;
import com.example.rewebdemo.dto.UpdateRoomRequest;
import com.example.rewebdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private static List<Employee> employees = new ArrayList<Employee>();

    @Autowired
    EmployeeService employeeService;

    private Employee findEmployeeByID(String employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody CreateEmployeeRequest request) {

        return employeeService.createEmployee(request);

    }

    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{employeeID}")
    public Employee getEmployee(@PathVariable Long employeeID) {

        return employeeService.getEmployeeById(employeeID);
    }

    @PutMapping("/employee/{employeeID}")
    public Employee updateEmployee(@PathVariable Long employeeID,
                                   @RequestBody UpdateEmployeeRequest request) {

        return employeeService.updateEmployee(employeeID, request);
    }

    @DeleteMapping("/employee/{employeeID}")
    public Responsedto disableEmployee(@PathVariable Long employeeID) {
        return employeeService.disableEmployee(employeeID);
    }

    private Employee findEmployeeById(String employeeID) {
        for (Employee employee: employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }


}
