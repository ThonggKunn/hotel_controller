package com.example.rewebdemo.dto;

import lombok.Data;

@Data
public class CreateEmployeeRequest {

    private String employeeName;

    private String employeeID;

    private String position;
}
