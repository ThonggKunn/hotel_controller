package com.example.rewebdemo.Entity;

import lombok.Data;

@Data
public class Employee {

    private String employeeName;

    private String employeeID;

    private String position;

    private boolean status = true;
}
