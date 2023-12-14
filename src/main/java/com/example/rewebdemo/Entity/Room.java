package com.example.rewebdemo.Entity;

import lombok.Data;

@Data
public class Room {

    private String roomID;

    private String roomType;

    private boolean status = true;
}
