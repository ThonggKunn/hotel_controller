package com.example.rewebdemo.service;

import com.example.rewebdemo.Entity.Employee;
import com.example.rewebdemo.dto.CreateEmployeeRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateEmployeeRequest;
import com.example.rewebdemo.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long Id) {
        return employeeRepository.findByEmployeeId(Id);
    }

    public Employee createEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setEmployeeName(request.getEmployeeName());
        employee.setEmployeeID(request.getEmployeeID());

        employee = employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long employeeId, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {
            return null;
        }

        employee.setEmployeeID(request.getEmployeeID());
        employee.setEmployeeID(request.getEmployeeID());

        return employee;
    }

    public Responsedto disableEmployee(Long employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {
            return new Responsedto(false, "Not Found");
        }
        employee.setStatus(false);
        employee = employeeRepository.save(employee);
        return new Responsedto(true, "Fired");
    }
}
