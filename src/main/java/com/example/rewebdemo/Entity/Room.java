package com.example.rewebdemo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue

    @Column(name = "roomId")
    private String roomID;

    @Column(name = "roomType")
    private String roomType;

    @Column(name = "status")
    private boolean status = true;
}
