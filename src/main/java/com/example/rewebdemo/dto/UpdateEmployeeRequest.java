package com.example.rewebdemo.dto;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {

    private String employeeName;

    private String employeeID;

    private String position;

    private boolean status;
}
