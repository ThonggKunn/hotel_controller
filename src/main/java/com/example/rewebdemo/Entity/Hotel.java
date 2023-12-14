package com.example.rewebdemo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {

    @Id
    @GeneratedValue

    @Column(name = "id")
    private String hotelID;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "status")
    private boolean status = true;

    @Column(name = "Rate")
    private Integer rate;
}

