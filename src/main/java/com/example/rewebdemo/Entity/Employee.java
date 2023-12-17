package com.example.rewebdemo.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue

    @Column(name = "Name")
    private String employeeName;

    @Column(name = "id")
    private String employeeID;

    @Column(name = "position")
    private String position;

    @Column(name = "status")
    private boolean status = true;



}
