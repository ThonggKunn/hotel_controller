package com.example.rewebdemo.controller;

import com.example.rewebdemo.Entity.Employee;
import com.example.rewebdemo.dto.CreateEmployeeRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateEmployeeRequest;
import com.example.rewebdemo.dto.UpdateRoomRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private static List<Employee> employees = new ArrayList<Employee>();

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

        Employee employee = new Employee();

        employee.setEmployeeID(request.getEmployeeID());
        employee.setEmployeeName(request.getEmployeeName());
        employee.setPosition(request.getPosition());

        employees.add(employee);
        return employee;

    }

    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employees;
    }

    @GetMapping("/employee/{employeeID}")
    public Employee getEmployee(@PathVariable String employeeID) {

        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    @PutMapping("/employee/{employeeID}")
    public Employee updateEmployee(@PathVariable String employeeID,
                                   @RequestBody UpdateEmployeeRequest request) {

        Employee employee = findEmployeeByID(employeeID);
        if (employeeID == null) {
            return null;
        }

        employee.setEmployeeName(request.getEmployeeName());
//        employee.setEmployeeID(request.getEmployeeID());
//        employee.setPosition(request.getPosition());
        employee.setStatus(request.isStatus());

        return employee;
    }

    @DeleteMapping("/employee/{employeeID}")
    public Employee disableEmployee(@PathVariable String employeeID) {


        if (employeeID == null) {
            return null;
        }

        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                employee.setStatus(false);
            }
        }
        return null;

    }


}
