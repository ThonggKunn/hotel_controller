package com.example.rewebdemo.repository;

import com.example.rewebdemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeName(String employeeName);

    Employee findByEmployeeId(Long Id);


}
